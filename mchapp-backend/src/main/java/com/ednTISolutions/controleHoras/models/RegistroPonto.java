package com.ednTISolutions.controleHoras.models;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * Edney Roldao - 07/11/2017
 *
 */
@Document(collection = "registroPonto")
public class RegistroPonto {

	@Id
	private BigInteger id;
	private String profileEmail;
	private LocalDate dataRegistro;
	private List<LocalTime> registros;

	
	public RegistroPonto(String profileEmail) {
		this.profileEmail = profileEmail;
		dataRegistro = LocalDate.now();
		registros = new ArrayList<>();
	}

	
	@Override
	public String toString() {
		return "RegistroPonto [id=" + id + ", profileEmail=" + profileEmail + ", dataRegistro=" + dataRegistro
				+ ", registros=" + registros + "]";
	}

	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getProfileEmail() {
		return profileEmail;
	}

	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public List<LocalTime> getRegistros() {
		return registros;
	}

	public void setRegistros(List<LocalTime> registros) {
		this.registros = registros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((profileEmail == null) ? 0 : profileEmail.hashCode());
		result = prime * result + ((registros == null) ? 0 : registros.hashCode());
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
		RegistroPonto other = (RegistroPonto) obj;
		if (dataRegistro == null) {
			if (other.dataRegistro != null)
				return false;
		} else if (!dataRegistro.equals(other.dataRegistro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (profileEmail == null) {
			if (other.profileEmail != null)
				return false;
		} else if (!profileEmail.equals(other.profileEmail))
			return false;
		if (registros == null) {
			if (other.registros != null)
				return false;
		} else if (!registros.equals(other.registros))
			return false;
		return true;
	}

}
