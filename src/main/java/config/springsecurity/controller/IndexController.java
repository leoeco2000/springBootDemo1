package config.springsecurity.controller;

import javax.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import config.springsecurity.entity.Msg;
import config.springsecurity.service.SysUserService;

@Controller
public class IndexController {

  @Resource
  private SysUserService sysUserService;

  @RequestMapping("/home")
  public String home() {
    return "home";
  }

  // @RequestMapping("/login")
  // public String login() {
  // return "page/login/login";
  // }

  // @RequestMapping("/")
  // public String root() {
  // return "index";
  // }

  @RequestMapping("/")
  public String index(Model model) {
    Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
    model.addAttribute("msg", msg);
    return "home";
  }
  @RequestMapping(value ="/welcome", method = RequestMethod.GET)
  String welcome() {
    return "welcome";
  }

  @RequestMapping("/login")
  public String login(Model model) {
    return "login";
  }
  @RequestMapping("/403")
  public String error() {
    return "403";
  }
}
