package com.thoughtworks.iamcoach.pos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pos {
    private Scanner scanner;
    private PromotionHelper promotionHelper;

    public Pos() {
    }

    public Pos(Scanner scanner, PromotionHelper promotionHelper) {
        this.scanner = scanner;
        this.promotionHelper = promotionHelper;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public PromotionHelper getPromotionHelper() {
        return promotionHelper;
    }

    public void setPromotionHelper(PromotionHelper promotionHelper) {
        this.promotionHelper = promotionHelper;
    }

    public void printInventory(List<String> barcodes) throws Exception {

        List<CartItem> cartItemList = this.getScanner().scan(barcodes);
        StringBuffer stringBuffer = new StringBuffer("\t\t\t\t\t let us go购物清单 \t\t\t\t\t\t\n\n");
        stringBuffer.append("\t\t\t\t\t\t\t\t\t"+this.getDate()+"\n\n");
        stringBuffer.append("\t名称 \t\t单位 \t\t价格 \t\t数量 \t\t小计\n\n");

        for(CartItem cartItem:cartItemList){
            stringBuffer.append("\t"+cartItem.getProduct().getName()+" \t");
            stringBuffer.append(" \t"+cartItem.getProduct().getUnit()+" \t\t");
            stringBuffer.append(" \t"+cartItem.getProduct().getPrice()+" \t");
            stringBuffer.append(" \t"+cartItem.getCount()+" \t");
            stringBuffer.append(" \t"+this.getPromotionHelper().calculateMoney(cartItem)+"\n");
        }
        System.out.println(stringBuffer.toString());
    }

    private String getDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
