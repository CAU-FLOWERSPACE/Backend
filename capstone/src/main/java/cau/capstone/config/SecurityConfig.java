package cau.capstone.config;

//import cau.capstone.config.auth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Configuration // IoC에 등록, 메모리에 떠야한다.
@EnableWebSecurity // 해당 파일로 시큐리티를 활성화한다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  @Autowired
//  private CustomOAuth2UserService customOAuth2UserService;

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }



  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
      .authorizeRequests()
      .anyRequest ().permitAll()
        .and()
      .formLogin()
      .usernameParameter("email")
      .passwordParameter("password");

//    http
//      .oauth2Login()
//      .userInfoEndpoint()
//      .userService(customOAuth2UserService);

  }
}
