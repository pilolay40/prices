package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class DiscountPriceShould {

    DiscountBoundary discount;
    @BeforeEach
    public  void setUp() {
        discount = new DiscountPrice();
    }

    @Test
    public void shouldNotApplicableDiscount() {

        BigDecimal actual = BigDecimal.ZERO;
        BigDecimal expected = discount.getDiscount(BigDecimal.ZERO);

        assertEquals(actual,expected);

    }

    @Test
    public void shoulAplicableDiscount() {

        BigDecimal actual = BigDecimal.valueOf(3);
        BigDecimal expected = discount.getDiscount(BigDecimal.valueOf(1400));

        assertEquals(actual,expected);
    }
}