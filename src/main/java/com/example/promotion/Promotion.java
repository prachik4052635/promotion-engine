package com.example.promotion;

import java.util.List;

public interface Promotion {
    int apply(List<CartItem> items);
}
