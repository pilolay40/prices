package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;

import java.math.BigDecimal;

public class DiscountPrice implements DiscountBoundary {

    @Override
    public BigDecimal getDiscount(BigDecimal amount) {
        return BigDecimal.ZERO;
    }
}
