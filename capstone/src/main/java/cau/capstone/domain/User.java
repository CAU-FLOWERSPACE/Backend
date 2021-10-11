package cau.capstone.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false) // 제약조건이 걸린다
  private String email;

  @Column(length = 20, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;



  // 회원, 비회원
  // 관리자

}
