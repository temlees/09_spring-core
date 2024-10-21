package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Component // 이 클래스를 빈으로 등록한다는 뜻
public class MemberDAO {

    private   Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        this.memberMap = new HashMap<>();
        //final이지만  new HashMap<>(); 은 못바꾸지만 값을 채워넣는건 가능하다

        memberMap.put(1,new MemberDTO(1,"user01","pass01","홍길동"));

        memberMap.put(2,new MemberDTO(2,"user02","pass02","홍길순"));

    }

    //매개변수로 전달받은 회원정보를 map에서 조회후 회원정보 리턴 메소드

    public MemberDTO selection(int seq){
        return memberMap.get(seq);
    }

    //매개변수로 전달 받은 회원 정보를 map에 추가하고 성공 실패 여부를
    //boolean 형식으로 리턴하는 메소드

    public boolean insertMember(MemberDTO member){
        int before = memberMap.size();
        memberMap.put(member.getSequence(), member);

        return memberMap.size() >before? true : false;
    }
}
