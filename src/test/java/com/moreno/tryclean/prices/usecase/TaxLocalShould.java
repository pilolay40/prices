package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.TaxLocalBoundary;
import com.moreno.tryclean.prices.entity.Tax;
import com.moreno.tryclean.prices.entity.gateway.TaxEntityGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaxLocalShould {

    @Mock
    private TaxEntityGateway taxEntityGateway;
    private TaxLocalBoundary taxLocalBoundary;
    private final String ESTATE_TEST = "BAL";

    @BeforeEach
    void setUp() {
        taxLocalBoundary = new TaxLocal(taxEntityGateway);
    }

    @Test
    public void shouldReturnTaxLocal() {
        when(taxEntityGateway.getTaxLocal(ESTATE_TEST)).thenReturn(getTaxBal());
        BigDecimal expected = new BigDecimal("18.3");
        BigDecimal actual = taxLocalBoundary.getTaxPercentage(ESTATE_TEST);
        assertEquals(actual,expected);
    }

    private Tax getTaxBal() {
        return new Tax(ESTATE_TEST,new BigDecimal("18.3"));
    }

    @Test
    void shouldReturnTaxLocalRESWhenNotFoundState() {
        when(taxEntityGateway.getTaxLocal("MAD")).thenReturn(getTaxLocalRES());
        BigDecimal expected = new BigDecimal("21.5");
        BigDecimal actual = taxLocalBoundary.getTaxPercentage("MAD");
        assertEquals(actual,expected);

    }

    private Tax getTaxLocalRES() {
        return new Tax("RES",new BigDecimal("21.5"));
    }


}