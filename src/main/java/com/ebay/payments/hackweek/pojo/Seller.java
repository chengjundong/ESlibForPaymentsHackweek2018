package com.ebay.payments.hackweek.pojo;

import java.io.Serializable;

public class Seller implements Serializable {

	private static final long serialVersionUID = -7680972358431120197L;

	private String userName;
	private String contactEmail;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String toString() {
		return "Seller [userName=" + userName + ", contactEmail=" + contactEmail + "]";
	}
}
