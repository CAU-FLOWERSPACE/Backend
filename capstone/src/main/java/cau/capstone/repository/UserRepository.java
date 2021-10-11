package cau.capstone.repository;

import cau.capstone.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  // JPA named query 사용한다

}
