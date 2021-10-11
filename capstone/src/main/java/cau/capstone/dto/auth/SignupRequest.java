package cau.capstone.dto.auth;

import cau.capstone.domain.User;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class SignupRequest { // 요청하는 dto
  // 통신할 때 필요한 data를 담아두는 object

  @NotBlank
  private String email;
  @NotBlank
  private String username;
  @NotBlank
  private String password;

  public User toEntity() {
    return User.builder()
      .email(email)
      .password(password)
      .username(username)
      .build();

  }

}
