package com.moreno.tryclean.prices.usecase;

import com.moreno.tryclean.prices.boundaries.DiscountBoundary;
import com.moreno.tryclean.prices.entity.Discount;
import com.moreno.tryclean.prices.entity.gateway.DiscountEntityGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class DiscountPriceShould {


    @Mock
    private DiscountEntityGateway discountEntityGateway;

    private DiscountBoundary discount;
    @BeforeEach
    public  void setUp() {
        discount = new DiscountPrice(discountEntityGateway);
    }

    @Test
    public void shouldNotApplicableDiscount() {
        when(discountEntityGateway.getDiscountsBetweenMount(BigDecimal.ZERO)).thenReturn(withOutDiscount());
        BigDecimal actual = BigDecimal.ZERO;
        BigDecimal expected = discount.getDiscount(BigDecimal.ZERO);

        assertEquals(actual,expected);

    }

    private Discount withOutDiscount() {
        Discount discount = new Discount(1l,BigDecimal.ZERO,BigDecimal.valueOf(100));
        return discount;
    }

    @Test
    public void shoulAplicableDiscount() {
        when(discountEntityGateway.getDiscountsBetweenMount(BigDecimal.valueOf(1200))).thenReturn(withDiscount());
        BigDecimal actual = BigDecimal.valueOf(3);
        BigDecimal expected = discount.getDiscount(BigDecimal.valueOf(1200));

        assertEquals(actual,expected);
    }

    private Discount withDiscount() {
        Discount discount = new Discount(1l,BigDecimal.valueOf(3),BigDecimal.valueOf(1400));
        return discount;
    }


}