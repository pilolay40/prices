package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import com.moreno.tryclean.prices.entity.Discount;
import com.moreno.tryclean.prices.entity.gateway.DiscountEntityGateway;

import java.math.BigDecimal;

public class DiscountPrice implements DiscountBoundary {

    private DiscountEntityGateway entityGateway;

    public DiscountPrice(DiscountEntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public BigDecimal getDiscount(BigDecimal amount) {
        Discount discount = entityGateway.getDiscountsBetweenMount(amount);
        return discount.getDiscountPercentage();
    }
}
