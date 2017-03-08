package com.lardi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lardi.model.Contact;
import com.lardi.service.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "loginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut() {
		return "loginForm";
	}

	@RequestMapping(value = "/enter", method = RequestMethod.POST)
	public String enter(@RequestParam(value = "userLogin", required = false) String userLogin,
			@RequestParam(value = "userPassword", required = false) String userPassword, Model model) {
		
			String login = userService.authorization(userLogin, userPassword);
			
			if (login != null && !login.isEmpty()) {
				
				Integer userId = userService.getUserId(login);
				List<Contact> contactList = userService.contactList(userId);
				
				model.addAttribute("contactList", contactList);
				
				return "user";
				
			} else {
				
				model.addAttribute("msg", "Пользователь отсутствует в базе. Зарегистрируйтесь.");
				
				return "userError";
			}
		}
	}

