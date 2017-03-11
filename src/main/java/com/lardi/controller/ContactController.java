package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lardi.model.Contact;
import com.lardi.service.ContactServiceImpl;
import com.lardi.service.UserServiceImpl;

@Controller
@RequestMapping("/contactController")
public class ContactController {

	@Autowired
	ContactServiceImpl contactService;

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showFormOfAddingContact(@RequestParam(value = "userId", required = true) Integer userId,
			Model model) {
		Contact contact = new Contact();
		contact.setUser(userService.findById(userId));
		model.addAttribute("contactAttribute", contact);
		return "addContactForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingContact(@RequestParam(value = "userId", required = true) Integer userId,
			@ModelAttribute("contactAttribute") Contact contact, Model model) {
		contactService.create(userId, contact);
		return "userPage";
	}
}
