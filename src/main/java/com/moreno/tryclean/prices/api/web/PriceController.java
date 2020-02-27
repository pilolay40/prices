package com.moreno.tryclean.prices.api.web;

import com.moreno.tryclean.prices.api.dto.ItemRequest;
import com.moreno.tryclean.prices.boundaries.PricingBoundaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PricingBoundaries pricing;


    @GetMapping("/price")
    public ResponseEntity<BigDecimal> calculatePrice(ItemRequest request){

        return  new ResponseEntity<>(pricing.calculateTotalAmount(
                                    request.getItemDescription(),
                                    request.getItemPrice(),
                                    request.getNumberOfItems(),
                                    request.getState()), HttpStatus.OK);
    }

    @GetMapping
   public String sayHola(){
        return "Hola, ya tu sabes";
   }

}
