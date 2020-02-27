package com.moreno.tryclean.prices.external.entityrepository;

import com.moreno.tryclean.prices.entity.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountEntityRepositoryShould {

    private DiscountEntityRepository discountEntityRepository;

    @BeforeEach
    public void setUp() {
        discountEntityRepository = new DiscountEntityRepository();
    }

    @Test
    void shouldReturnZeroPorcentage() {

        BigDecimal expeted = BigDecimal.valueOf(0);
        Discount actual = discountEntityRepository.getDiscountsBetweenMount(new BigDecimal(500));
        assertEquals(expeted ,actual.getDiscountPercentage());

    }
    @Test
    void shouldReturn3Porcentage() {

        BigDecimal expeted = BigDecimal.valueOf(3);
        Discount actual = discountEntityRepository.getDiscountsBetweenMount(new BigDecimal(1000));
        assertEquals(expeted ,actual.getDiscountPercentage());
    }

    @Test
    void shouldReturn7Porcentage() {

        BigDecimal expeted = BigDecimal.valueOf(7);
        Discount actual = discountEntityRepository.getDiscountsBetweenMount(new BigDecimal(2000));
        assertEquals(expeted ,actual.getDiscountPercentage());

    }

    @Test
    void shouldReturn15Porcentage() {

        BigDecimal expeted = BigDecimal.valueOf(15);
        Discount actual = discountEntityRepository.getDiscountsBetweenMount(new BigDecimal(5000));
        assertEquals(expeted ,actual.getDiscountPercentage());

    }

    @Test
    void shouldReturn19Porcentage() {

        BigDecimal expeted = BigDecimal.valueOf(19);
        Discount actual = discountEntityRepository.getDiscountsBetweenMount(new BigDecimal(6500));
        assertEquals(expeted ,actual.getDiscountPercentage());

    }

    @Test
    void shouldReturn26Porcentage() {

        BigDecimal expeted = BigDecimal.valueOf(26);
        Discount actual = discountEntityRepository.getDiscountsBetweenMount(new BigDecimal(10000));
        assertEquals(expeted ,actual.getDiscountPercentage());

    }


}