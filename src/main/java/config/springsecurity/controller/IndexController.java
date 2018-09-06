package config.springsecurity.controller;

import javax.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import config.springsecurity.entity.UserVO;
import config.springsecurity.service.SUserService;

@Controller
public class IndexController {

  @Resource
  private SUserService sUserService;

  @RequestMapping("/home")
  public String home() {
    return "home";
  }

  @PreAuthorize("hasRole('user')")
  @RequestMapping(value = "/admin", method = RequestMethod.POST)
  public String toAdmin() {
    return "helloAdmin";
  }

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }

//  @RequestMapping("/login")
//  public String login() {
//    return "page/login/login";
//  }

  @RequestMapping(value ="/welcome", method = RequestMethod.GET)
  String welcome() {
    return "welcome";
  }

  @RequestMapping(value ="/login", method = RequestMethod.GET)
  String login(Model model, UserVO user) {
    model.addAttribute("user", user);
    return "index";
  }
  
  @RequestMapping("/")
  public String root() {
    return "index";
  }

  @RequestMapping("/403")
  public String error() {
    return "403";
  }
}
