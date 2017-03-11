package com.lardi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lardi.model.Contact;
import com.lardi.model.User;
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

	@RequestMapping(value = "/enter", method = RequestMethod.POST)
	public String enter(@RequestParam(value = "userLogin", required = true) String userLogin,
			@RequestParam(value = "userPassword", required = true) String userPassword, Model model) {
		boolean autRet = userService.aut(userLogin, userPassword);
		if (autRet == true) {
			User user = userService.findUserByLogin(userLogin);
			List<Contact> list = contactService.search(user.getUserId());
			model.addAttribute("user", user);
			model.addAttribute("list", list);

		}
		return "userPage";
	}
}
