package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import com.moreno.tryclean.prices.boundaries.PricingBoundaries;
import com.moreno.tryclean.prices.boundaries.SpecialTaxBoundary;
import com.moreno.tryclean.prices.boundaries.TaxLocalBoundary;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pricing implements PricingBoundaries {

    private DiscountBoundary discount;
    private TaxLocalBoundary tax;
    private SpecialTaxBoundary specialTax;
    private final BigDecimal HUNDRED = new BigDecimal("100");

    public Pricing(DiscountBoundary discount, TaxLocalBoundary tax, SpecialTaxBoundary specialTax) {
        this.discount = discount;
        this.tax = tax;
        this.specialTax = specialTax;
    }

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {
        if(isCalculateTotal(itemPrice, numberOfItems)){
            return BigDecimal.ZERO;
        }

        BigDecimal base = applyDiscount(itemPrice.multiply(BigDecimal.valueOf(numberOfItems)));

        BigDecimal total = base.add(getLocalTaxAmount(base, state))
                .add(getSpecialTaxAmount(base, itemDescription));
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    private boolean isCalculateTotal(BigDecimal itemPrice, Integer numberOfItems) {
        return (itemPrice==null || itemPrice.compareTo(BigDecimal.ZERO) <= 0 ) || (numberOfItems==null || numberOfItems <=0);
    }

    private BigDecimal applyDiscount(BigDecimal amount) {
        BigDecimal discountPercentage = discount.getDiscount(amount);
        if (discountPercentage != null) {
            return amount.multiply(BigDecimal.ONE.subtract(discountPercentage.divide(HUNDRED)));
        }
        return amount;
    }

    private BigDecimal getLocalTaxAmount(BigDecimal amount, String state) {
        BigDecimal stateTaxPercentage = tax.getTaxPercentage(state);
        return calculateTaxAmount(amount, stateTaxPercentage);
    }

    private BigDecimal getSpecialTaxAmount(BigDecimal amount, String itemDescription) {
        BigDecimal specialTaxPercentage = specialTax.getSpecialTaxPercentageByItemDescription(itemDescription);
        if (specialTaxPercentage != null) {
            return calculateTaxAmount(amount, specialTaxPercentage);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal calculateTaxAmount(BigDecimal amount, BigDecimal taxPercentage) {

        return amount.multiply(taxPercentage.divide(HUNDRED));
    }



}
