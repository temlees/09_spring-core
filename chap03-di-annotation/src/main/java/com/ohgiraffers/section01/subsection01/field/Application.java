package com.ohgiraffers.section01.subsection01.field;

import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.ohgiraffers.section01");

        BookService bookservice = context.getBean(BookService.class);

        List<BookDTO> bookDTOList = bookservice.selectAllBook();
        for (BookDTO book: bookDTOList) {
            System.out.println("book: " + book);
        }

        System.out.println(bookservice.selectOneBook(1));
    }
}
