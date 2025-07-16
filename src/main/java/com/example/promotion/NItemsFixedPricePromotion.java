package com.example.promotion;

import java.util.List;

public class NItemsFixedPricePromotion implements Promotion {
    String skuId;
    int requiredQuantity;
    int promoPrice;

    public NItemsFixedPricePromotion(String skuId, int requiredQuantity, int promoPrice) {
        this.skuId = skuId;
        this.requiredQuantity = requiredQuantity;
        this.promoPrice = promoPrice;
    }

    @Override
    public int apply(List<CartItem> items) {
        int total = 0;
        for (CartItem item : items) {
            if (item.getSku().getId().equals(skuId)) {
                int quantity = item.getQuantity();
                int unitPrice = item.getSku().getUnitPrice();
                int offerSets = quantity / requiredQuantity;
                int remaining = quantity % requiredQuantity;
                total += offerSets * promoPrice + remaining * unitPrice;
            }
        }
        return total;
    }
}
