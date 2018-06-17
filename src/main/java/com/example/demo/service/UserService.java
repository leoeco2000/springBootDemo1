package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

  int addUser(User user);

  List<User> findAllUser(int pageNum, int pageSize);

  PageInfo<User> findAllUserPage(int pageNum, int pageSize);
}