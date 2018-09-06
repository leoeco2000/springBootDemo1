package config.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import config.springsecurity.entity.SysUser;
import config.springsecurity.mapper.UserMapper;

@Service
public class SysUserService {

  @Autowired
  private UserMapper userMapper;// code10

  public SysUser findByUserName(String userName) {
    return userMapper.findByUserName(userName);
  }

}
