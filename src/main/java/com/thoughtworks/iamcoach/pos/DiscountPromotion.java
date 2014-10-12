package com.thoughtworks.iamcoach.pos;

public class DiscountPromotion extends Promotion{
    
    public double getMoney(CartItem cartItem, int discount) {

        double money = cartItem.getProduct().getPrice() * cartItem.getCount() * discount / 100.0;
        return money;
    }

    @Override
    public double getMoney(CartItem cartItem) {
        return 0;
    }
}
