package com.goal.controller;

import com.goal.entity.Book;
import com.goal.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class TestHandler {

    @Autowired
    private BookRepository bookRepository;

    public void test(){
        Book book = new Book(1, "Spring", "张三", "重庆出版社", 99.9F);
        bookRepository.saveAndFlush(book);
    }

}
