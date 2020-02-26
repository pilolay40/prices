package com.moreno.tryclean.prices.boundaries;

import java.math.BigDecimal;

public interface DiscountBoundary {

    BigDecimal getDiscount(BigDecimal amount);
}
