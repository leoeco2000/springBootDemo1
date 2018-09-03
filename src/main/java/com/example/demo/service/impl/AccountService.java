package com.example.demo.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.TestCache;
import com.example.demo.dao.IAccountDAO;
import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.IAccountService;
import ch.qos.logback.core.net.SyslogOutputStream;

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
  @Cacheable("accounts")
  public List<Account> findAccountList() {
    List<Account> list = accountDAO.findAccountList();
    return list;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW,
      // isolation = Isolation.READ_COMMITTED,
      // noRollbackFor = {TException.class},
      readOnly = false, timeout = 3)
  public int updateAccountById(int id) throws RuntimeException {
    int a;
    if ((id & 1) != 0) {
      a = 1 / 0;
    }
    a = accountMapper.updateAccountById(id, 1);
    return a;
  }
}
