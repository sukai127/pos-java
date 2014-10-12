package com.thoughtworks.iamcoach.pos;

public class BuyTwoGetOnePromotion extends Promotion{
    @Override
    public double getMoney(CartItem cartItem) {
        return 0;
    }
}
