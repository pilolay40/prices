package com.moreno.tryclean.prices.usecase;


import com.moreno.tryclean.prices.api.dto.ItemRequest;
import com.moreno.tryclean.prices.boundaries.PricingBoundaries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PricingShould {

    private PricingBoundaries pricing;

    @BeforeEach
    public void setUp() {
        pricing = new Pricing();
    }

    @Test
    public void shouldReturnZeroWithPriceOrNumberOfItemIsZero() {

        ItemRequest itemRequest = new ItemRequest("TV",new BigDecimal(0),0,"BAL");
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
    public void showReturnSumOfPrice() {
        ItemRequest itemRequest = new ItemRequest("Bike",new BigDecimal(1000),2,"CAN");
        BigDecimal expected = new BigDecimal(2000);
        BigDecimal actual = pricing.calculateTotalAmount(
                itemRequest.getItemDescription(),
                itemRequest.getItemPrice(),
                itemRequest.getNumberOfItems(),
                itemRequest.getState()
        );
        assertEquals(expected, actual);
    }
}