package cau.capstone.controller;

import cau.capstone.domain.User;
import cau.capstone.dto.auth.JoinRequest;
import cau.capstone.dto.auth.JoinResponse;
import cau.capstone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;


  // 회원가입

  @PostMapping("/join")
  public ResponseEntity<JoinResponse> join(@Valid @RequestBody JoinRequest joinRequest) {

    Long saveId = userService.join(joinRequest);
    return new ResponseEntity<>(new JoinResponse(saveId), HttpStatus.CREATED);

  }
}
