package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.PricingBoundaries;

import java.math.BigDecimal;

public class Pricing implements PricingBoundaries {

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription​, BigDecimal itemPrice, Integer numberOfItems, String state) {
        if(isCalculateTotal(itemPrice, numberOfItems)){
            return BigDecimal.ZERO;
        }
        return itemPrice.multiply(new BigDecimal(numberOfItems));
    }

    private boolean isCalculateTotal(BigDecimal itemPrice, Integer numberOfItems) {
        return (itemPrice==null || itemPrice.compareTo(BigDecimal.ZERO) <= 0 ) || (numberOfItems==null || numberOfItems <=0);
    }

}
