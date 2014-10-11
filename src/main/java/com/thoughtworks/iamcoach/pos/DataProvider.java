package com.thoughtworks.iamcoach.pos;

/**
 * Created by sukai on 10/11/14.
 */
public class DataProvider {
    public Product buildProduct(String productString) {

        String []fields = productString.split(",");
        double price = Double.parseDouble(fields[3]);

        Product product = new Product(fields[0],fields[1],fields[2],price);
        return product;
    }
}
