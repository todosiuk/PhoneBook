package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lardi.model.User;
import com.lardi.service.UserServiceImpl;
import com.lardi.validator.LoginValidator;

@Controller
@RequestMapping("/registrationController")
public class RegistrationController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
	public ModelAndView showFormOfAddingUser() {
		return new ModelAndView("registrationPage", "userAttribute", new User());
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String savingUser(@ModelAttribute("userAttribute") User user, Model model) {
		boolean loginValid = LoginValidator.isValid(user.getUserLogin());
		if (loginValid == true) {
			userService.create(user);
			model.addAttribute("msg", "Пользователь " + user.getFullName() + " успешно зарегистрирован");
			return "success";
		} else {
			model.addAttribute("msg", "Логин должен содержать только латинские буквы");
			return "success";
		}

	}
}