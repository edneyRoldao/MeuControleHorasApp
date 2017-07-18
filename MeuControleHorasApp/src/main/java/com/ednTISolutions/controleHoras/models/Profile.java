package com.ednTISolutions.controleHoras.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by edneyroldao on 07/06/17.
 */
@Document
public class Profile {

	@Id
	private BigInteger id;

	private String email;

	private String name;

	private String company;

	private String avatar;

	public Profile() {

	}

	public Profile(String email, String name, String company, String avatar) {
		this.email = email;
		this.name = name;
		this.company = company;
		this.avatar = avatar;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
