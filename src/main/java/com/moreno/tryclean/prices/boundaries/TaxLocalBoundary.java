package com.moreno.tryclean.prices.boundaries;

import java.math.BigDecimal;

public interface TaxLocalBoundary {

    BigDecimal getTaxPercentage(String state);
}
