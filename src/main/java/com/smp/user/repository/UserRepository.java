package com.smp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smp.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndDeleteDateIsNull(String username);

}
