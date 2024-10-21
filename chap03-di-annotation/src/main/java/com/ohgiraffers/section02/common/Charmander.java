package com.ohgiraffers.section02.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //동일한 타입의 클래스중 가장 우선 순위로 여기겠다
public class Charmander implements  Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃세례!!!");
    }
}
