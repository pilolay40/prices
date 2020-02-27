package com.moreno.tryclean.prices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Tax {

    private String state;
    private BigDecimal percentage;

}
