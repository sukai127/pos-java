package com.thoughtworks.iamcoach.pos;

public abstract class Promotion {
    
    public static final int BUY_TWO_GET_ONE = 0;
    public static final int SECOND_HALF_PRICE = 1;
    public static final int DISCOUNT = 2;

    public abstract double getMoney(CartItem cartItem);

}
