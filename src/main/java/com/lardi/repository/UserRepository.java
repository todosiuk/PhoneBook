package com.lardi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lardi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserLogin(String userLogin);

}
