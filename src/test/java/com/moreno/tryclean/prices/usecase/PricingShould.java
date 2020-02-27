package com.moreno.tryclean.prices.usecase;


import com.moreno.tryclean.prices.api.dto.ItemRequest;
import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import com.moreno.tryclean.prices.boundaries.PricingBoundaries;
import com.moreno.tryclean.prices.boundaries.SpecialTaxBoundary;
import com.moreno.tryclean.prices.boundaries.TaxLocalBoundary;
import com.moreno.tryclean.prices.entity.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PricingShould {

    @Mock
    private TaxLocalBoundary taxLocal;

    @Mock
    private DiscountBoundary discount;

    @Mock
    private SpecialTaxBoundary specialTax;

    private PricingBoundaries pricing;


    @BeforeEach
    public void setUp() {
        pricing = new Pricing(discount,taxLocal,specialTax);
    }

    @Test
    public void shouldReturnZeroWithPriceOrNumberOfItemIsZero() {

        ItemRequest itemRequest = new ItemRequest("TV",BigDecimal.valueOf(0),0,"BAL");
        BigDecimal expected = BigDecimal.ZERO;
        BigDecimal actual = pricing.calculateTotalAmount(
                itemRequest.getItemDescription(),
                itemRequest.getItemPrice(),
                itemRequest.getNumberOfItems(),
                itemRequest.getState()
        );
        assertEquals(expected, actual);
    }


    @Test
    public void shouldCalculateTotalAmountForBALState() {
        when(taxLocal.getTaxPercentage("BAL")).thenReturn(BigDecimal.valueOf(18.3));
        when(discount.getDiscount(any())).thenReturn(null);
        ItemRequest itemRequest = new ItemRequest("TV",BigDecimal.valueOf(123),4,"BAL");
        BigDecimal expected = BigDecimal.valueOf(582.04);
        BigDecimal actual = pricing.calculateTotalAmount(
                itemRequest.getItemDescription(),
                itemRequest.getItemPrice(),
                itemRequest.getNumberOfItems(),
                itemRequest.getState());

        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateTotalAmountForTobaccoAtRES(){
        when(taxLocal.getTaxPercentage("RES")).thenReturn(BigDecimal.valueOf(21.5));
        when(specialTax.getSpecialTaxPercentageByItemDescription("tobacco")).thenReturn(BigDecimal.valueOf(50));
        when(discount.getDiscount(any())).thenReturn(null);
        ItemRequest itemRequest = new ItemRequest("tobacco", BigDecimal.valueOf(6), 3, "RES");

        BigDecimal expected = BigDecimal.valueOf(30.87);
        BigDecimal actual = pricing.calculateTotalAmount(
                itemRequest.getItemDescription(),
                itemRequest.getItemPrice(),
                itemRequest.getNumberOfItems(),
                itemRequest.getState()
        );
        assertEquals(expected, actual);
    }


}