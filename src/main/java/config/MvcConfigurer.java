package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/login").setViewName("login");
//    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  }

//  @Override
//  public void configurePathMatch(PathMatchConfigurer configurer) {
//    configurePathMatch(configurer);
//    configurer.setUseSuffixPatternMatch(false);
//  }
}
