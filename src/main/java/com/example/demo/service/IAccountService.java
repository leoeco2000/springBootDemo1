package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface IAccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

    int updateAccountById(int id);

}
