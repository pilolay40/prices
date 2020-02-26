package com.moreno.tryclean.prices.usecase;


import com.moreno.tryclean.prices.api.dto.ItemRequest;
import com.moreno.tryclean.prices.boundaries.PricingBoundaries;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PricingShould {

    @Test
    public void shouldReturnZeroWithPriceOrNumberOfItemIsZero() {
        PricingBoundaries pricing = new Pricing();
        ItemRequest itemRequest = new ItemRequest("TV",new BigDecimal(0),0,"BAL");
        BigDecimal expected = new BigDecimal(0);
        BigDecimal actual = pricing.calculateTotalAmount(
                itemRequest.getItemDescription(),
                itemRequest.getItemPrice(),
                itemRequest.getNumberOfItems(),
                itemRequest.getState()
        );
        assertEquals(expected, actual);
    }


}