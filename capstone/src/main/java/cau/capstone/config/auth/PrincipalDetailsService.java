package cau.capstone.config.auth;

import cau.capstone.domain.User;
import cau.capstone.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PrincipalDetailsService implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    User userEntity = userRepository.findByEmail(email);

    if (userEntity != null) {
      return new PrincipalDetails(userEntity);
    }
    return null;
  }
}
