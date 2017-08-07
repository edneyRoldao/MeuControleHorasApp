package com.ednTISolutions.controleHoras.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * Created by edneyroldao on 07/06/17.
 */
@Document(collection = "profiles")
public class Profile {

	@Id
	private BigInteger id;

	private String name;
	private String email;
	private Calendar birthDate;
	private Character gender;
	private String avatar;
	private String company;
	private String profession;
	private BigDecimal valorHora;
	private Integer horasPorMes;
	private Integer maxHorasPorMes;
	private Address address;

	public Profile() {
	}

	public Profile(User user) {
		email = user.getUsername();
		name = user.getFirstname();
		company = "";
		avatar = "";
	}

	public Profile(BigInteger id, String name, String email, Calendar birthDate, Character gender, String avatar,
			String company, String profession, BigDecimal valorHora, Integer horasPorMes, Integer maxHorasPorMes,
			Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.gender = gender;
		this.avatar = avatar;
		this.company = company;
		this.profession = profession;
		this.valorHora = valorHora;
		this.horasPorMes = horasPorMes;
		this.maxHorasPorMes = maxHorasPorMes;
		this.address = address;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHorasPorMes() {
		return horasPorMes;
	}

	public void setHorasPorMes(Integer horasPorMes) {
		this.horasPorMes = horasPorMes;
	}

	public Integer getMaxHorasPorMes() {
		return maxHorasPorMes;
	}

	public void setMaxHorasPorMes(Integer maxHorasPorMes) {
		this.maxHorasPorMes = maxHorasPorMes;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", gender="
				+ gender + ", avatar=" + avatar + ", company=" + company + ", profession=" + profession + ", valorHora="
				+ valorHora + ", horasPorMes=" + horasPorMes + ", maxHorasPorMes=" + maxHorasPorMes + ", address="
				+ address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((horasPorMes == null) ? 0 : horasPorMes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxHorasPorMes == null) ? 0 : maxHorasPorMes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + ((valorHora == null) ? 0 : valorHora.hashCode());
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
		Profile other = (Profile) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (horasPorMes == null) {
			if (other.horasPorMes != null)
				return false;
		} else if (!horasPorMes.equals(other.horasPorMes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxHorasPorMes == null) {
			if (other.maxHorasPorMes != null)
				return false;
		} else if (!maxHorasPorMes.equals(other.maxHorasPorMes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		if (valorHora == null) {
			if (other.valorHora != null)
				return false;
		} else if (!valorHora.equals(other.valorHora))
			return false;
		return true;
	}

}
