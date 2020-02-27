package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import com.moreno.tryclean.prices.entity.Discount;
import com.moreno.tryclean.prices.entity.gateway.DiscountEntityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountPrice implements DiscountBoundary {

    private DiscountEntityGateway entityGateway;

    @Autowired
    public DiscountPrice(DiscountEntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public BigDecimal getDiscount(BigDecimal amount) {
        Discount discount = entityGateway.getDiscountsBetweenMount(amount);
        return discount.getDiscountPercentage();
    }
}
