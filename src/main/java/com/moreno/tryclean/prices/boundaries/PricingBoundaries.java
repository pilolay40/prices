package com.moreno.tryclean.prices.boundaries;

import java.math.BigDecimal;

public interface PricingBoundaries {

    BigDecimal calculateTotalAmount(
            String itemDescription​,
            BigDecimal itemPrice,
            Integer numberOfItems,
            String state);
}
