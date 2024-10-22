package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {

/*
*   aspectJ 의 AutoProxy 사용에 관한 설정을 해 주어야
*   advice 가 동작한다..
*   ProxyTargetClass = true설정은
*   cglib을 통한 프록시를 생성하는 방식이다
*       (cglib : 클래스 기반의 프록시를 생성하는 라이브러리
*   메소드 호출을 가로채기 위해 실제클래스의 서브클래스를 만든다..)
* */
}
