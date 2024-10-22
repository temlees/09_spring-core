package com.ohgiraffers.section01.common;


import org.springframework.stereotype.Repository;

import java.util.*;

//bean으로 관리되며 db 와 커넥션 객체를 담당
//지금은 컴포넌트와 같은 역할을한다
@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {

    private Map<Integer,BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1,new BookDTO(1,123,"자바의 정석","남궁성","도우출판",new Date()));
        bookList.put(2,new BookDTO(2,456,"컨테이너","문성주","길벗",new Date()));

    }


    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
     //new ArrayList<>(bookList.values())는 Map에서 값을 꺼내와 새로운 리스트로 변환하기 위한 작업이며
        // ,이는 List 타입으로 변환하여 반환하기 위해 필요합니다.
        //new ArrayList<>(...)는 새로운 ArrayList 객체를 생성하는 코드
        //생성자 인자에 Collection을 넘기면, 그 Collection의 모든 요소를 복사해서 새로운 리스트를 만듭니다
        //한마디로 맵에 있는 VALUE를 꺼내 새로운 배열에 넣고 그걸 반환하겠다는 뜻이다
    }

    @Override
    public BookDTO selectOneBook(int seq) {
        return bookList.get(seq);
    }
}
