package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    //final 이라 setter 없음
    //빵 음료 가 들어올수 있다
    private final List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product item) {
        items.add(item);
    }



    public List<Product> getItems() {
        return items;
    }

}
