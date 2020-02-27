package com.moreno.tryclean.prices.external.entityrepository;

import com.moreno.tryclean.prices.entity.Tax;
import com.moreno.tryclean.prices.entity.gateway.TaxEntityGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxLocalRepositoryShould {

    private TaxEntityGateway taxEntityGateway;

    @BeforeEach
    void setUp() {
        taxEntityGateway = new TaxLocalRepository();
    }

    @Test
    public void showReturnRESTAXIfNotFoundTaxByState() {
        Tax actual = taxEntityGateway.getTaxLocal("MAD");
        Tax expected = new Tax("MAD", BigDecimal.valueOf(21.5));
        assertEquals(actual.getPercentage(),expected.getPercentage());
    }

    @Test
    public void showReturnTaxByState() {
        Tax actual = taxEntityGateway.getTaxLocal("CAN");
        Tax expected = new Tax("CAN", BigDecimal.valueOf(4.7));
        assertEquals(actual.getPercentage(),expected.getPercentage());
    }
}