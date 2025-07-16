package com.example.promotion;

import java.util.List;

public class PromotionEngine {
    List<Promotion> promotions;

    public PromotionEngine(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int calculateTotal(Cart cart) {
        int total = 0;
        for (Promotion promotion : promotions) {
            total += promotion.apply(cart.getItems());
        }
        return total;
    }
}
