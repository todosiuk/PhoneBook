package com.lardi.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.lardi.app.PhoneBookTest;
import com.lardi.controller.LoginController;
import com.lardi.model.Contact;
import com.lardi.model.User;
import com.lardi.service.ContactServiceImpl;
import com.lardi.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class LoginControllerTest {

	@Mock
	UserServiceImpl userService;
	@Mock
	ContactServiceImpl contactService;

	@InjectMocks
	private LoginController loginController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void homeTest() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("loginForm"));
	}

	@Test
	public void logOutTest() throws Exception {
		mockMvc.perform(get("/logout")).andExpect(status().isOk()).andExpect(view().name("loginForm"));
	}
}
