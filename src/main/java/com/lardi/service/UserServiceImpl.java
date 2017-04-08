package com.lardi.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.lardi.model.User;
import com.lardi.model.UserCreateForm;
import com.lardi.repository.RoleRepository;
import com.lardi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	public Optional<User> getUserByLogin(String login) {
		return userRepository.findByUserLogin(login);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("login"));
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setUserLogin(form.getLogin());
		user.setUserPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
		user.setFullName(form.getName());
		user.setRole(form.getRole());
		user.setContactsList(form.getContactsList());
		return userRepository.save(user);
	}
}
