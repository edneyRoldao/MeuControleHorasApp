package com.ednTISolutions.controleHoras.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by edneyroldao on 07/06/17.
 */
@Entity
@Table(name = "TB_USER_PROFILE")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 50)
	@Column(length = 50, unique = true)
	private String email;

	@NotNull
	@Column(length = 30)
	@Size(min = 3, max = 30)
	private String name;

	@Transient
	private String token;

	@Column(length = 50)
	private String company;

	@Column(length = 500, unique = true)
	private String idPhoto;

	public UserProfile() {
	}

	public UserProfile(Long id, String email, String name, String token, String company, String idPhoto) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.token = token;
		this.company = company;
		this.idPhoto = idPhoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public static UserProfile createProfile(String name, String email) {
		UserProfile user = new UserProfile();
		user.setName(name);
		user.setEmail(email);
		
		return user;
	}

}
