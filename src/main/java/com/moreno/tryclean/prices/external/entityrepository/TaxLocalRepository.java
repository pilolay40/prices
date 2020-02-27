package com.moreno.tryclean.prices.external.entityrepository;

import com.moreno.tryclean.prices.entity.Tax;
import com.moreno.tryclean.prices.entity.gateway.TaxEntityGateway;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TaxLocalRepository implements TaxEntityGateway {

    private Map<String,Tax> taxes;

    public TaxLocalRepository() {
        this.taxes = new HashMap<>();
        //Un comentario de los malos, jajajaja. Podría crear un enum para no poner esos valores así a pedal, pero como
        //estos datos cendrían de allguna fuente
        taxes.put("BAL",new Tax("BAL", BigDecimal.valueOf(18.3)));
        taxes.put("CAN",new Tax("CAN", BigDecimal.valueOf(4.7)));
        taxes.put("CYM",new Tax("CYM", BigDecimal.valueOf(18.1)));
        taxes.put("TER",new Tax("TER", BigDecimal.valueOf(0.5)));
        taxes.put("RES",new Tax("RES", BigDecimal.valueOf(21.5)));
    }

    @Override
    public Tax getTaxLocal(String state) {
        Tax tax = taxes.get(state);
        if(tax==null){
            tax = taxes.get("RES");
        }
        return tax;
    }
}
