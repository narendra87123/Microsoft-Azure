package com.Manasvi.Career.repository;

import com.Manasvi.Career.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
  //  User findByuserName(String name);

}

