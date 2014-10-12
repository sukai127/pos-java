package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.List;

public class DiscountPromotion extends Promotion{

    @Override
    public double getMoney(CartItem cartItem) {
        List<String> list;
        try {
            list = FileHelper.get("discount_promotion.txt");
            int discount = 100;
            for(String str : list){
                if(str.contains(cartItem.getProduct().getBarcode())){
                    discount = Integer.parseInt(str.split(":")[1]);
                }
            }
            double money = cartItem.getProduct().getPrice() * cartItem.getCount() * discount / 100.0;
            return money;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartItem.getProduct().getPrice() * cartItem.getCount();
    }
}
