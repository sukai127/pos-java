package com.thoughtworks.iamcoach.pos;

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
}
