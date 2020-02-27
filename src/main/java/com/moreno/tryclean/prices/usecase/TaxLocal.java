package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.TaxLocalBoundary;
import com.moreno.tryclean.prices.entity.Tax;
import com.moreno.tryclean.prices.entity.gateway.TaxEntityGateway;

import java.math.BigDecimal;

public class TaxLocal implements TaxLocalBoundary {

    private TaxEntityGateway taxEntityGateway;

    public TaxLocal(TaxEntityGateway taxEntityGateway) {
        this.taxEntityGateway = taxEntityGateway;
    }

    @Override
    public BigDecimal getTaxPercentage(String state) {
        Tax taxLocal = taxEntityGateway.getTaxLocal(state);
        return taxLocal.getPercentage();
    }

}
