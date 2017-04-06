package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lardi.service.ContactServiceImpl;
import com.lardi.service.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	ContactServiceImpl contactService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home() {
		return "loginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut() {
		return "loginForm";
	}
}
