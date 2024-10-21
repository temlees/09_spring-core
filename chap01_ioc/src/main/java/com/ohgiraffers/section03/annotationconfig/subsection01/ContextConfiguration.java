package com.ohgiraffers.section03.annotationconfig.subsection01;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection03")
//configurationSection03 빈객체를 불러오는 기능을하는 빈 이다
@ComponentScan(basePackages = "com.ohgiraffers.common")
//ComponentScan 는 basePackages 하위에 있는 값들 중 bean을 가져올 수 있다
public class ContextConfiguration {
}
