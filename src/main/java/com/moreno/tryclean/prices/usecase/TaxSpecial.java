package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.SpecialTaxBoundary;
import com.moreno.tryclean.prices.entity.SpecialTax;
import com.moreno.tryclean.prices.entity.gateway.SpecialTaxEntityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxSpecial implements SpecialTaxBoundary {

    private SpecialTaxEntityGateway specialTaxEntityGateway;

    @Autowired
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
