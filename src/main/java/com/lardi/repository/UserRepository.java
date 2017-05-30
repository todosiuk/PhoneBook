package com.lardi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lardi.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
