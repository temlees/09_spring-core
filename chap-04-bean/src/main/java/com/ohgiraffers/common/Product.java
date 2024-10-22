package com.ohgiraffers.common;

public abstract class  Product {


    //추상클래스
    //상속받으면 다 사용가능
    //여기서 객체를 못 만듦
    private String name; //상품묭
    private int price; //가격

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+" "+price ;
    }
}
