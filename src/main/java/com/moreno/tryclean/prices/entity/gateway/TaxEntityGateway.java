package com.moreno.tryclean.prices.entity.gateway;

import com.moreno.tryclean.prices.entity.Tax;

public interface TaxEntityGateway {

    Tax getTaxLocal(String state);
}
