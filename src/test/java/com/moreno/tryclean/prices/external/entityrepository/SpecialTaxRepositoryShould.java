package com.moreno.tryclean.prices.external.entityrepository;

import com.moreno.tryclean.prices.entity.SpecialTax;
import com.moreno.tryclean.prices.entity.gateway.SpecialTaxEntityGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialTaxRepositoryShould {

    private SpecialTaxEntityGateway specialTaxEntityGateway;
    private final String ITEM_SPECIAL = "tobacco";

    @BeforeEach
    void setUp() {
        specialTaxEntityGateway = new SpecialTaxRepository();
    }

    @Test
    public void shouldReturnPorcentageItemSpecial() {
        SpecialTax expected = new SpecialTax(ITEM_SPECIAL,BigDecimal.valueOf(50));
        SpecialTax actual = specialTaxEntityGateway.getSpecialTaxByItemDescription(ITEM_SPECIAL);
        assertEquals(expected.getTaxPercentage(),actual.getTaxPercentage());


    }

    @Test
    public void shouldNotApplyPorcentageItemSpecial() {
        SpecialTax expected = new SpecialTax("OTRAVAINA",BigDecimal.valueOf(0));
        SpecialTax actual = specialTaxEntityGateway.getSpecialTaxByItemDescription("OTRAVAINA");
        assertEquals(expected.getTaxPercentage(),actual.getTaxPercentage());


    }


}