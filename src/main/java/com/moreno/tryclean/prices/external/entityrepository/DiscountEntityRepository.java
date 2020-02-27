package com.moreno.tryclean.prices.external.entityrepository;

import com.moreno.tryclean.prices.entity.Discount;
import com.moreno.tryclean.prices.entity.gateway.DiscountEntityGateway;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DiscountEntityRepository implements DiscountEntityGateway {

    private List<Discount> discounts;

    public DiscountEntityRepository() {

        this.discounts = new ArrayList<>();
        this.discounts.add(new Discount(1l,BigDecimal.valueOf(3),BigDecimal.valueOf(1000)));
        this.discounts.add(new Discount(2l,BigDecimal.valueOf(7),BigDecimal.valueOf(2000)));
        this.discounts.add(new Discount(3l,BigDecimal.valueOf(15),BigDecimal.valueOf(5000)));
        this.discounts.add(new Discount(4l,BigDecimal.valueOf(19),BigDecimal.valueOf(6500)));
        this.discounts.add(new Discount(5l,BigDecimal.valueOf(26),BigDecimal.valueOf(10000)));

    }

    @Override
    public Discount getDiscountsBetweenMount(BigDecimal mount) {
        return discounts.stream()
                .filter(discount -> discount.getAmount().compareTo(mount) <= 0)
                .max(Comparator.comparing(Discount::getAmount))
                .orElse(new Discount(0l,BigDecimal.valueOf(0),BigDecimal.valueOf(0)));


    }
}
