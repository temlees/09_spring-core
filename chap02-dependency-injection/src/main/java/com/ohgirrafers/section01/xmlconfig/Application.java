package com.ohgirrafers.section01.xmlconfig;

import com.ohgirrafers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext(
                "section01/xmlconfig/spring-context.xml");

        MemberDTO member = (MemberDTO) context.getBean("member");

        System.out.println(member.getPersonalAccount());
        //입금
        System.out.println(member.getPersonalAccount().deposit(10000));

        System.out.println(member.getPersonalAccount().getBalance());

        System.out.println(member.getPersonalAccount().withdraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());

        System.out.println(member.getPersonalAccount().withdraw(10000));


    }
}
