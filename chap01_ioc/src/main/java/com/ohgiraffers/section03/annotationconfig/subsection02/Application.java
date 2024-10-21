package com.ohgiraffers.section03.annotationconfig.subsection02;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext(
                "section03/annotationconfig/subsection02/xml/spring-context.xml"
        );

        String[] beanNames = context.getBeanDefinitionNames();
        for (String bean : beanNames) {
            System.out.println("Bean: " + bean);
        }
                // 컨테이너에서 MemberDAO타입을 가진 빈을 가져온다는 뜻
        MemberDAO memberDAO = context.getBean(MemberDAO.class);
        System.out.println(memberDAO.selection(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03","pass03","홍석삼")));

        System.out.println(memberDAO.selection(3));
    }
}
