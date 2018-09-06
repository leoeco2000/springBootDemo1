package config.springsecurity.customConfig;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import config.springsecurity.entity.SysRole;
import config.springsecurity.entity.SysUser;
import config.springsecurity.service.SysUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired // 数据库服务类
  private SysUserService sysuserService;// code7

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    // SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
    // 本例使用SUser中的email作为用户名:
    SysUser user = sysuserService.findByUserName(userName); // code8

    if (user == null) {
      throw new UsernameNotFoundException("UserName " + userName + " not found");
    }

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    // 用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
    for (SysRole role : user.getRoles()) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
      System.out.println(role.getName());
    }
    return new User(user.getUsername(), user.getPassword(), authorities); // code9

  }

}
