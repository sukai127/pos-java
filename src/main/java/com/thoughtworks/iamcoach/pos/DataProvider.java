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

    public List<Integer> getPromotionTypeList(String barcode) {
        return null;
    }
}
