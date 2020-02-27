package com.moreno.tryclean.prices.entity.gateway;

import com.moreno.tryclean.prices.entity.SpecialTax;


public interface SpecialTaxEntityGateway {

    SpecialTax getSpecialTaxByItemDescription(String itemDescription);
}
