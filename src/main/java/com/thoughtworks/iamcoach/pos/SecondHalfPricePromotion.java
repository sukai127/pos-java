package com.thoughtworks.iamcoach.pos;

public class SecondHalfPricePromotion extends Promotion {

    @Override
    public double getMoney(CartItem cartItem) {
        return 0;
    }
}
