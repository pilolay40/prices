package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.SpecialTaxBoundary;
import com.moreno.tryclean.prices.entity.SpecialTax;
import com.moreno.tryclean.prices.entity.gateway.SpecialTaxEntityGateway;

import java.math.BigDecimal;

public class TaxSpecial implements SpecialTaxBoundary {

    private SpecialTaxEntityGateway specialTaxEntityGateway;

    public TaxSpecial(SpecialTaxEntityGateway specialTaxEntityGateway) {
        this.specialTaxEntityGateway = specialTaxEntityGateway;
    }


    @Override
    public BigDecimal getSpecialTaxPercentageByItemDescription(String itemDescription) {
        SpecialTax specialTax = specialTaxEntityGateway.getSpecialTaxByItemDescription(itemDescription);
        if(specialTax==null){
            return BigDecimal.ZERO;
        }
        return specialTax.getTaxPercentage();
    }
}
