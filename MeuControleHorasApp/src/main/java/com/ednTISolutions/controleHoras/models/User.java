package com.ednTISolutions.controleHoras.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
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

	@Column(unique = true)
	private BigInteger profileId;

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

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public BigInteger getProfileId() {
		return profileId;
	}

	public void setProfileId(BigInteger profileId) {
		this.profileId = profileId;
	}

	public List<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", firstname='" + firstname + '\'' +
				", enabled=" + enabled +
				", lastPasswordResetDate=" + lastPasswordResetDate +
				", profileId=" + profileId +
				", authorities=" + authorities +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
		if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
			return false;
		if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
			return false;
		if (getFirstname() != null ? !getFirstname().equals(user.getFirstname()) : user.getFirstname() != null)
			return false;
		if (getEnabled() != null ? !getEnabled().equals(user.getEnabled()) : user.getEnabled() != null) return false;
		if (getLastPasswordResetDate() != null ? !getLastPasswordResetDate().equals(user.getLastPasswordResetDate()) : user.getLastPasswordResetDate() != null)
			return false;
		if (getProfileId() != null ? !getProfileId().equals(user.getProfileId()) : user.getProfileId() != null)
			return false;
		return getAuthorities() != null ? getAuthorities().equals(user.getAuthorities()) : user.getAuthorities() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
		result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
		result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
		result = 31 * result + (getEnabled() != null ? getEnabled().hashCode() : 0);
		result = 31 * result + (getLastPasswordResetDate() != null ? getLastPasswordResetDate().hashCode() : 0);
		result = 31 * result + (getProfileId() != null ? getProfileId().hashCode() : 0);
		result = 31 * result + (getAuthorities() != null ? getAuthorities().hashCode() : 0);
		return result;
	}

}