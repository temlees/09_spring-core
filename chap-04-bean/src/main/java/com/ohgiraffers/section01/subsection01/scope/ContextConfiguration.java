package com.ohgiraffers.section01.subsection01.scope;


import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread(){
        return  new Bread("붕어빵",1000,new Date());
    }

    @Bean
    public Product milk(){
        return new Beverage("딸기우유",1500,500);
    }

    @Bean
    public Product water(){
        return new Beverage("지리산암반수" ,1000,500);


    }

    @Bean
    @Scope("prototype")
    //하지만 prototype   붙이면 요청당 다른 인스턴스 넘겨준다.
    //default는  singleton이다
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
}
