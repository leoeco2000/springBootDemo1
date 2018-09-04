package com.example.demo.service;

import com.example.demo.bean.Book;

public interface BookRepository {

  Book getByIsbn(String isbn);
  Book testThread();

}
