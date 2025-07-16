package com.example.promotion;

import java.util.Arrays;
import java.util.List;

public class TotalCart {

    public static void main(String[] args) {
        SKU A = new SKU("A", 50);
        SKU B = new SKU("B", 30);
        SKU C = new SKU("C", 20);
        SKU D = new SKU("D", 15);

        Cart cartA = new Cart();
        cartA.addItem(new CartItem(A, 1));
        cartA.addItem(new CartItem(B, 1));
        cartA.addItem(new CartItem(C, 1));

        Cart cartB = new Cart();
        cartB.addItem(new CartItem(A, 5));
        cartB.addItem(new CartItem(B, 5));
        cartB.addItem(new CartItem(C, 1));

        Cart cartC = new Cart();
        cartC.addItem(new CartItem(A, 3));
        cartC.addItem(new CartItem(B, 5));
        cartC.addItem(new CartItem(C, 1));
        cartC.addItem(new CartItem(D, 1));

        List<Promotion> promotions = Arrays.asList(
            new NItemsFixedPricePromotion("A", 3, 130),
            new NItemsFixedPricePromotion("B", 2, 45),
            new ComboPromotion("C", "D", 30)
        );

        PromotionEngine engine = new PromotionEngine(promotions);

        System.out.println("Scenario A Total: " + engine.calculateTotal(cartA)); // 100
        System.out.println("Scenario B Total: " + engine.calculateTotal(cartB)); // 370
        System.out.println("Scenario C Total: " + engine.calculateTotal(cartC)); // 280
    }
}
