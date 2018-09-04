package com.example.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.bean.Book;
import com.example.demo.service.BookRepository;

@Service
public class BookService implements BookRepository {

  @Override
  @Cacheable("books1")
  public Book getByIsbn(String isbn) {
    simulateSlowService();
    return new Book(isbn, "Some book");
  }

  // Don't do this at home
  private void simulateSlowService() {
    try {
      long time = 3000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public Book testThread() {
    System.out
        .println("主线程启动子线程时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    /* 阻塞等待 */
    try {
      TimeUnit.SECONDS.sleep(5L);
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    /* 运行 */
    new Thread(() -> {
      while (true) {
        /* 执行方法 */
        System.out.println(
            "子线程执行任务，当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
          /* 任务执行间隔 */
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    return null;
  }

}
