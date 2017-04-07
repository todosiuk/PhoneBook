package com.lardi.service;

import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.lardi.model.User;
import com.lardi.repository.RoleRepository;
import com.lardi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService<User, String> {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findByUserLogin(login);
	}
}
