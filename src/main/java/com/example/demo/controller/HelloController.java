package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.Book;
import com.example.demo.service.IAccountService;
import com.example.demo.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

  @Autowired
  BookService bookService;
  
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/books")
    public Book getBooks() {
        return bookService.getByIsbn("1");
    }

}