package cau.capstone.controller;

import cau.capstone.domain.User;
import cau.capstone.dto.auth.JoinRequest;
import cau.capstone.dto.auth.JoinResponse;
import cau.capstone.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "http://localhost:3002") //해당 리액트 포트 번호. // 이거 뭔지 확인해보기
@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  // 회원가입

  @PostMapping("/api/join")
  public ResponseEntity<JoinResponse> join(@Valid @RequestBody JoinRequest joinRequest) {

    log.info("회원가입 요청 완료 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    Long saveId = userService.join(joinRequest);
    return new ResponseEntity<>(new JoinResponse(saveId), HttpStatus.CREATED);

  }
}
