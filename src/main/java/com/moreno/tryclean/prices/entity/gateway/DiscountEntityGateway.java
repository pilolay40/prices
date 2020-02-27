package com.moreno.tryclean.prices.entity.gateway;

import com.moreno.tryclean.prices.entity.Discount;

import java.math.BigDecimal;

public interface DiscountEntityGateway {

    Discount getDiscountsBetweenMount(BigDecimal mount);
}
