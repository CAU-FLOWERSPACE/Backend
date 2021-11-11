package cau.capstone.config.auth;

import cau.capstone.domain.User;
import cau.capstone.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrincipalDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    log.info(String.format("[loadUserByUsername]: request_email -> %s", email));
    User userEntity = userRepository.findByEmail(email);

    if(userEntity == null) {
      throw new UsernameNotFoundException(String.format("회원이 존재하지 않습니다 -> " + email));
    }

    return new PrincipalDetails(userEntity);
  }
}

//
//  @Override
//  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    Optional< UserEntity > user= userRepository.findByEmail(email);
//    user.orElseThrow(()-> new UsernameNotFoundException("Not found: " + email));
//    return user.map(UserInfo::new).get();
//  }
