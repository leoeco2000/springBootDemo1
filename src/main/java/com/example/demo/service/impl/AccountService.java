package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.IAccountDAO;
import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.IAccountService;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountDAO accountDAO;
    @Autowired
    AccountMapper accountMapper;
    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }

    @Override
    @Transactional
    public int updateAccountById(int id) throws RuntimeException{
        int a = accountMapper.updateAccountById(id,1);
//        int i = 1/0;
        int b = accountMapper.updateAccountById(id,1);
        return a+b;
    }
}
