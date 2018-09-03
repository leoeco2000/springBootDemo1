package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface AccountMapper {
  int add(Account account);

  int update(Account account);

  int delete(int id);

  Account findAccountById(int id);

  List<Account> findAccountList();

  int updateAccountById(@Param("id") int id, @Param("money") double money);
}
