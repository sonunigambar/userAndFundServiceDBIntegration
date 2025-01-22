package com.codingcure.userService.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcure.userService.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
