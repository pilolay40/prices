package com.moreno.tryclean.prices.external.entityrepository;

import com.moreno.tryclean.prices.entity.SpecialTax;
import com.moreno.tryclean.prices.entity.gateway.SpecialTaxEntityGateway;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SpecialTaxRepository implements SpecialTaxEntityGateway {

    private Map<String, SpecialTax> specialTaxMap;

    public SpecialTaxRepository() {
        this.specialTaxMap = new HashMap<>();
        //Un comentario de los malos, jajajaja. Podría crear un enum para no poner esos valores así a pedal, pero como
        //estos datos cendrían de allguna fuente
        specialTaxMap.put("tobacco",new SpecialTax("tobacco", BigDecimal.valueOf(50)));

    }


    @Override
    public SpecialTax getSpecialTaxByItemDescription(String itemDescription) {
        SpecialTax specialTax = specialTaxMap.get(itemDescription);
        if(specialTax==null){
            specialTax = new SpecialTax("",BigDecimal.ZERO);
        }
        return specialTax;
    }


}
