package com.moreno.tryclean.prices.boundaries;

import java.math.BigDecimal;

public interface SpecialTaxBoundary {

    BigDecimal getSpecialTaxPercentageByItemDescription(String itemDescription);
}
