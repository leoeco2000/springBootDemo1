package config.springsecurity.customConfig;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

//@Configuration
public class ErrorPageConfig {

  @Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
    return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
      @Override
      public void customize(ConfigurableWebServerFactory factory) {
//        factory.setPort(8081);
        factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
      }
    };
  }

}
