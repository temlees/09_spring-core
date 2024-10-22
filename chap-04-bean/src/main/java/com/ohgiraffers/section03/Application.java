package com.ohgiraffers.section03;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.subsection01.java.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext(
                "xmlconfig/spring-context.xml");


        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        //첫 번째 손님이 쇼핑카트를 꺼낸다
        ShoppingCart cart = context.getBean("cart", ShoppingCart.class);
        cart.addItem(carpBread);
        cart.addItem(milk);
        System.out.println("cart에 담긴 물품 :" +cart.getItems());

        //두번째 손님이 카트를 꺼낸다
        // 하나의 인스턴스여서 전꺼와 같이나온다..
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 에 담긴 상품 : "+cart2.getItems());

        //context 종료
        ((GenericXmlApplicationContext)context).close();
    }
}
