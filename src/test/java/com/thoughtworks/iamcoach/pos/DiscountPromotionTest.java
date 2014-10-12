package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountPromotionTest {
    @Test
    public void should_return_12_when_input_cartItem(){
        Product product = new Product("ITEM000000","可乐","瓶",3.00);
        CartItem cartItem = new CartItem(product,5);
        DiscountPromotion discountPromotion = new DiscountPromotion();

        double money = discountPromotion.getMoney(cartItem,80);

        assertThat(money).isEqualTo(12);
    }
}
