package com.example.promotion;

import java.util.List;

public class ComboPromotion implements Promotion {
    String skuId1;
    String skuId2;
    int comboPrice;

    public ComboPromotion(String skuId1, String skuId2, int comboPrice) {
        this.skuId1 = skuId1;
        this.skuId2 = skuId2;
        this.comboPrice = comboPrice;
    }

    @Override
    public int apply(List<CartItem> items) {
        int count1 = 0;
        int count2 = 0;
        int price1 = 0;
        int price2 = 0;

        for (CartItem item : items) {
            if (item.getSku().getId().equals(skuId1)) {
                count1 = item.getQuantity();
                price1 = item.getSku().getUnitPrice();
            }
            if (item.getSku().getId().equals(skuId2)) {
                count2 = item.getQuantity();
                price2 = item.getSku().getUnitPrice();
            }
        }

        int combos = Math.min(count1, count2);
        int remaining1 = count1 - combos;
        int remaining2 = count2 - combos;

        return combos * comboPrice + remaining1 * price1 + remaining2 * price2;
    }
}
