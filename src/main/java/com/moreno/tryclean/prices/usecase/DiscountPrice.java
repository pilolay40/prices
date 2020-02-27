package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import com.moreno.tryclean.prices.entity.Discount;
import com.moreno.tryclean.prices.entity.gateway.DiscountEntityGateway;
import com.moreno.tryclean.prices.external.entityrepository.DiscountEntityRepository;

import java.math.BigDecimal;

public class DiscountPrice implements DiscountBoundary {

    private DiscountEntityGateway entityGateway = new DiscountEntityRepository();

    @Override
    public BigDecimal getDiscount(BigDecimal amount) {
        Discount discount = entityGateway.getDiscountsBetweenMount(amount);
        return discount.getDiscountPercentage();
    }
}
