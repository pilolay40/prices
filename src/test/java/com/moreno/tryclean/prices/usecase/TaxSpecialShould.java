package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.SpecialTaxBoundary;
import com.moreno.tryclean.prices.entity.SpecialTax;
import com.moreno.tryclean.prices.entity.gateway.SpecialTaxEntityGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaxSpecialShould {

    @Mock
    private SpecialTaxEntityGateway specialTaxEntityGateway;
    private SpecialTaxBoundary specialTaxBoundary;
    private final String PRODUCT_SPECIAL = "tobacco";

    @BeforeEach
    void setUp() {
        specialTaxBoundary = new TaxSpecial(specialTaxEntityGateway);
    }

    @Test
    void shouldReturnExpecialTaxWithProductTobacco() {
        when(specialTaxEntityGateway.getSpecialTaxByItemDescription(PRODUCT_SPECIAL)).thenReturn(getSpecialTax());
        BigDecimal actual = specialTaxBoundary.getSpecialTaxPercentageByItemDescription(PRODUCT_SPECIAL);
        BigDecimal expected = BigDecimal.valueOf(50);

        assertEquals(actual,expected);

    }

    private SpecialTax getSpecialTax() {
        return new SpecialTax(PRODUCT_SPECIAL,BigDecimal.valueOf(50));
    }

    @Test
    void shouldReturnZeroIfNOExpecialTax() {
        when(specialTaxEntityGateway.getSpecialTaxByItemDescription("VAINA")).thenReturn(getNormalItem());
        BigDecimal actual = specialTaxBoundary.getSpecialTaxPercentageByItemDescription("VAINA");
        BigDecimal expected = BigDecimal.ZERO;

        assertEquals(actual,expected);

    }

    private SpecialTax getNormalItem() {
        return new SpecialTax("VAINA",BigDecimal.ZERO);
    }
}