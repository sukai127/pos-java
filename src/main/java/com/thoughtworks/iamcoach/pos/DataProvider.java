package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public Product buildProduct(String productString) {

        String []fields = productString.split(",");
        double price = Double.parseDouble(fields[3]);

        Product product = new Product(fields[0],fields[1],fields[2],price);
        return product;
    }

    public List<Product> getProductList() throws IOException {

        List<Product> productList = new ArrayList<Product>();
        List<String> productStringList = FileHelper.get("products.txt");

        for(String str : productStringList){
            Product product = this.buildProduct(str);
            productList.add(product);
        }

        return productList;
    }

    public List<Integer> getPromotionTypeList(String barcode) throws IOException {

        List<String> buyTwoGetOneList = FileHelper.get("buy_two_get_one_free_promotion.txt");
        List<String> secondHalfPriceList = FileHelper.get("second_half_price_promotion.txt");
        List<String> discountList = FileHelper.get("discount_promotion.txt");
        List<Integer> promotionList = new ArrayList<Integer>();

        if(buyTwoGetOneList.contains(barcode)){
            promotionList.add(Promotion.BUY_TWO_GET_ONE);
        }
        if(secondHalfPriceList.contains(barcode)){
            promotionList.add(Promotion.SECOND_HALF_PRICE);
        }
        if(isExist(discountList,barcode)){
            promotionList.add(Promotion.DISCOUNT);
        }
        return promotionList;
    }

    private boolean isExist(List<String> discountList, String barcode) {
        for(String str : discountList){
            if(str.contains(barcode)){
                return true;
            }
        }
        return false;
    }
}
