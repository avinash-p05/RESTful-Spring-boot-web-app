package com.matrixglitch.restfulwebservices.jpa;

import com.matrixglitch.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
