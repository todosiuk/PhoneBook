package com.lardi.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * This will function as a data transfer object (DTO)
 *  between the web layer and service layer.
 */

public class UserCreateForm {
	@NotEmpty
	private String login = "";

	@NotEmpty
	private String password = "";

	private String passwordRepeated = "";

	@NotEmpty
	private String name = "";

	private List<Contact> contactsList = new ArrayList<Contact>();

	@NotNull
	private Role role = Role.USER;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Contact> getContactsList() {
		return contactsList;
	}

	public void setContactsList(List<Contact> contactsList) {
		this.contactsList = contactsList;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	@Override
	public String toString() {
		return "UserCreateForm [login=" + login + ", password=" + password + ", passwordRepeated=" + passwordRepeated
				+ ", name=" + name + ", contactsList=" + contactsList + ", role=" + role + "]";
	}

}
