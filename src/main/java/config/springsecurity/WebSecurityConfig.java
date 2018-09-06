package config.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import config.springsecurity.customConfig.CustomUserDetailsService;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Bean
//  @Override
//  protected AuthenticationManager authenticationManager() throws Exception {
//    return super.authenticationManager();
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    //允许所有用户访问"/"和"/home"
//    http.authorizeRequests()
//    .antMatchers("/", "/home").permitAll()
//      //其他地址的访问均需验证权限
//      .anyRequest().authenticated()
//      .and()
//      .formLogin()
//      //指定登录页是"/login"
//      .loginPage("/login")
//      .failureUrl("/login?error")
//      .defaultSuccessUrl("/demo")//登录成功后默认跳转到"/hello"
//      .permitAll()
//      .and()
//      .logout()
//      .logoutSuccessUrl("/home")//退出登录后的默认url是"/home"
//      .permitAll();
//  }
//
//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//    .userDetailsService(customUserDetailsService())
//    .passwordEncoder(passwordEncoder());
//  }
//
//  /**
//   * 设置用户密码的加密方式为MD5加密
//   * 
//   * @return
//   */
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//  }
//
//  /**
//   * 自定义UserDetailsService，从数据库中读取用户信息
//   * 
//   * @return
//   */
//  @Bean
//  public CustomUserDetailsService customUserDetailsService() {
//    return new CustomUserDetailsService();
//  }
//
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    // 解决静态资源被拦截的问题
//    web.ignoring().antMatchers("/css/**");
//    web.ignoring().antMatchers("/lib/**");
//    web.ignoring().antMatchers("/page/**");
//  }
//}

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("123456").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // 解决静态资源被拦截的问题
    web.ignoring().antMatchers("/css/**");
    web.ignoring().antMatchers("/lib/**");
    web.ignoring().antMatchers("/page/**");
  }
}
