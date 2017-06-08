package com.ednTISolutions.controleHoras.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 50)
	@Column(length = 50, unique = true)
	private String username;

	@NotNull
	private String password;

	@NotNull
	@Column(length = 30)
	@Size(min = 3, max = 30)
	private String firstname;

	@NotNull
	private Boolean enabled;

	@DateTimeFormat
	private Date lastPasswordResetDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_USER_ROLE", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private List<Role> authorities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", enabled=" + enabled + ", lastPasswordResetDate=" + lastPasswordResetDate + ", authorities="
				+ authorities + "]";
	}

}