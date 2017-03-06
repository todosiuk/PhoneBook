package com.lardi.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	
	public Contact() {
		super();
	}

	public Contact(String contactSurname, String contactName, String contactPatronymic,
			String contactMobilePhone, String contactHomePhone, String contactAddress, String contactEmail, User user) {
		super();
		this.contactSurname = contactSurname;
		this.contactName = contactName;
		this.contactPatronymic = contactPatronymic;
		this.contactMobilePhone = contactMobilePhone;
		this.contactHomePhone = contactHomePhone;
		this.contactAddress = contactAddress;
		this.contactEmail = contactEmail;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer contactId;

	@NotBlank
	@Size(min = 4)
	@Column(name = "surname")
	private String contactSurname;

	@NotBlank
	@Size(min = 4)
	@Column(name = "name")
	private String contactName;

	@NotBlank
	@Size(min = 4)
	@Column(name = "patronymic")
	private String contactPatronymic;

	@NotBlank
	@Column(name = "mobilePhone")
	private String contactMobilePhone;

	@Column(name = "homePhone")
	private String contactHomePhone;

	@Column(name = "address")
	private String contactAddress;

	@Email
	@Column(name = "email")
	private String contactEmail;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "user_iduser")
	private User user;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactSurname() {
		return contactSurname;
	}

	public void setContactSurname(String contactSurname) {
		this.contactSurname = contactSurname;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPatronymic() {
		return contactPatronymic;
	}

	public void setContactPatronymic(String contactPatronymic) {
		this.contactPatronymic = contactPatronymic;
	}

	public String getContactMobilePhone() {
		return contactMobilePhone;
	}

	public void setContactMobilePhone(String contactMobilePhone) {
		this.contactMobilePhone = contactMobilePhone;
	}

	public String getContactHomePhone() {
		return contactHomePhone;
	}

	public void setContactHomePhone(String contactHomePhone) {
		this.contactHomePhone = contactHomePhone;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactAddress == null) ? 0 : contactAddress.hashCode());
		result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result + ((contactHomePhone == null) ? 0 : contactHomePhone.hashCode());
		result = prime * result + ((contactId == null) ? 0 : contactId.hashCode());
		result = prime * result + ((contactMobilePhone == null) ? 0 : contactMobilePhone.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((contactPatronymic == null) ? 0 : contactPatronymic.hashCode());
		result = prime * result + ((contactSurname == null) ? 0 : contactSurname.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactAddress == null) {
			if (other.contactAddress != null)
				return false;
		} else if (!contactAddress.equals(other.contactAddress))
			return false;
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactHomePhone == null) {
			if (other.contactHomePhone != null)
				return false;
		} else if (!contactHomePhone.equals(other.contactHomePhone))
			return false;
		if (contactId == null) {
			if (other.contactId != null)
				return false;
		} else if (!contactId.equals(other.contactId))
			return false;
		if (contactMobilePhone == null) {
			if (other.contactMobilePhone != null)
				return false;
		} else if (!contactMobilePhone.equals(other.contactMobilePhone))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (contactPatronymic == null) {
			if (other.contactPatronymic != null)
				return false;
		} else if (!contactPatronymic.equals(other.contactPatronymic))
			return false;
		if (contactSurname == null) {
			if (other.contactSurname != null)
				return false;
		} else if (!contactSurname.equals(other.contactSurname))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactSurname=" + contactSurname + ", contactName=" + contactName
				+ ", contactPatronymic=" + contactPatronymic + ", contactMobilePhone=" + contactMobilePhone
				+ ", contactHomePhone=" + contactHomePhone + ", contactAddress=" + contactAddress + ", contactEmail="
				+ contactEmail + ", user=" + user + "]";
	}

}
