package com.example.demo.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.bean.Book;
import com.example.demo.service.impl.BookService;

@Controller
public class HelloController {

  @Autowired
  BookService bookService;

  @RequestMapping("/demo")
  public String index(HashMap<String, Object> map) {
    // return "Greetings from Spring Boot!";
    bookService.testThread();
    map.put("hello", "欢迎进入HTML页面");
    return "page/demo/demo";
  }

  @RequestMapping("/books")
  public Book getBooks() {
    return bookService.getByIsbn("1");
  }

}
