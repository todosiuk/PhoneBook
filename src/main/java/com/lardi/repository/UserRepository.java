package com.lardi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lardi.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("select u from Users u where u.username =:username ")
	Users findByUsername(@Param("username") String username);
}
