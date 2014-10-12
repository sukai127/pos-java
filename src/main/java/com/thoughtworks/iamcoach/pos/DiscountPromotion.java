package com.thoughtworks.iamcoach.pos;

/**
 * Created by sukai on 10/12/14.
 */
public class DiscountPromotion extends Promotion{
    public double getMoney(CartItem cartItem, int i) {
        return 0;
    }

    @Override
    public double getMoney(CartItem cartItem) {
        return 0;
    }
}
