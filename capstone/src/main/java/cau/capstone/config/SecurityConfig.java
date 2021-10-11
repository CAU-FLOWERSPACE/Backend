package cau.capstone.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@Configuration // IoC에 등록, 메모리에 떠야한다.
@EnableWebSecurity // 해당 파일로 시큐리티를 활성화한다.
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public BCryptPasswordEncoder encode() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
      .authorizeRequests()
      .anyRequest().permitAll()
      .and()
      .formLogin()
      .defaultSuccessUrl("/");

  }
}
