package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BarcodeScanner implements Scanner{
    public Product getProduct(String barcode) throws IOException {

        DataProvider dataProvider = new DataProvider();
        List<Product> list = dataProvider.getProductList();

        for(Product product : list){
            if(product.getBarcode().equals(barcode)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List scan(List<String> barcodes) {
        return null;
    }
}
