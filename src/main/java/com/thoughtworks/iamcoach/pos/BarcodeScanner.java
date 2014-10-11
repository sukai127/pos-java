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
    public List scan(List<String> barcodes) throws IOException {
        List<CartItem> cartitemList = new ArrayList<CartItem>();

        for(String str : barcodes){
            String []fields = str.split("-");
            String barcode = str.split("-")[0];
            double count = 1;
            if(fields.length>1){
                count = Double.parseDouble(fields[1]);
            }
            Product product = this.getProduct(barcode);
            int index = this.getIndex(barcode,cartitemList);
            if( index == -1){
                CartItem cartitem = new CartItem(product,count);
                cartitemList.add(cartitem);
            }else{
                CartItem cartitem = cartitemList.get(index);
                cartitem.setCount(cartitem.getCount()+1);
                cartitemList.set(index,cartitem);
            }
        }
        return cartitemList;
    }

    private int getIndex(String barcode,List<CartItem> cartitemList){

        for(int i = 0; i < cartitemList.size(); i++){
            if(cartitemList.get(i).getProduct().getBarcode().equals(barcode)){
                return i;
            }
        }
        return -1;
    }
}
