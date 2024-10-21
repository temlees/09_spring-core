package com.ohgirrafers.section02.javaconfig;


import com.ohgirrafers.common.Account;
import com.ohgirrafers.common.MemberDTO;
import com.ohgirrafers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {


    //Bean 쓴 이유 싱글톤으로 써서 중복안되게
    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20,"110-233-2222");
    }

    @Bean
    public MemberDTO memberGenerator(){
        MemberDTO member = new MemberDTO(30,"홍석천","010-2222-3333","hong@gmail.com",accountGenerator());

        return member;

    }

}
