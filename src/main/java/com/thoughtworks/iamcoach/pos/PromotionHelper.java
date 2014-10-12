package com.thoughtworks.iamcoach.pos;

import java.util.Arrays;
import java.util.List;

public class PromotionHelper {

    public double calculateMoney(CartItem cartItem) {
        List<Integer> list = cartItem.getProduct().getPromotionTypes();
        double money[] = new double[list.size()];
        Promotion promotion = null;
        for (int i = 0; i < list.size(); i++) {
            int type = list.get(i);
            if (type == Promotion.BUY_TWO_GET_ONE) {
                promotion = new BuyTwoGetOnePromotion();
            }
            if (type == Promotion.SECOND_HALF_PRICE) {
                promotion = new SecondHalfPricePromotion();
            }
            if (type == Promotion.DISCOUNT) {
                promotion = new DiscountPromotion();
            }
            double subTotal = promotion.getMoney(cartItem);
            money[i] = subTotal;
        }
        Arrays.sort(money);
        
        return money[0];
    }
}
