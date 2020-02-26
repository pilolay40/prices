package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class DiscountPriceShould {

    @Test
    public void shouldNotApplicableDiscount() {
        DiscountBoundary discount = new DiscountPrice();
        BigDecimal actual = BigDecimal.ZERO;
        BigDecimal expected = discount.getDiscount(BigDecimal.ZERO);

        assertEquals(actual,expected);

    }
}