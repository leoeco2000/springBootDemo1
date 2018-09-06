package config.springsecurity.mapper;

import config.springsecurity.entity.SysUser;

public interface UserMapper {
  public SysUser findByUserName(String username);
}