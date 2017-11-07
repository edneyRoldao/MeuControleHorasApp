package com.ednTISolutions.controleHoras.models;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * Edney Roldao - 07/11/2017
 *
 */
@Document(collection = "marcacaoPonto")
public class MarcacaoPonto {

	@Id
	private BigInteger id;
	private String profileEmail;

	private LocalDateTime entrada;
	private LocalDateTime saidaIntervalo;
	private LocalDateTime entradaIntervalo;
	private LocalDateTime saida;

	// Constructor
	public MarcacaoPonto(String emailFromProfile) {
		profileEmail = emailFromProfile;
	}

	// Getters and Setters
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaidaIntervalo() {
		return saidaIntervalo;
	}

	public void setSaidaIntervalo(LocalDateTime saidaIntervalo) {
		this.saidaIntervalo = saidaIntervalo;
	}

	public LocalDateTime getEntradaIntervalo() {
		return entradaIntervalo;
	}

	public void setEntradaIntervalo(LocalDateTime entradaIntervalo) {
		this.entradaIntervalo = entradaIntervalo;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public String getProfileEmail() {
		return profileEmail;
	}

	@Override
	public String toString() {
		return "MarcacaoPonto [id=" + id + ", profileEmail=" + profileEmail + ", entrada=" + entrada
				+ ", saidaIntervalo=" + saidaIntervalo + ", entradaIntervalo=" + entradaIntervalo + ", saida=" + saida
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((entradaIntervalo == null) ? 0 : entradaIntervalo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((profileEmail == null) ? 0 : profileEmail.hashCode());
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
		result = prime * result + ((saidaIntervalo == null) ? 0 : saidaIntervalo.hashCode());
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
		MarcacaoPonto other = (MarcacaoPonto) obj;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (entradaIntervalo == null) {
			if (other.entradaIntervalo != null)
				return false;
		} else if (!entradaIntervalo.equals(other.entradaIntervalo))
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
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		if (saidaIntervalo == null) {
			if (other.saidaIntervalo != null)
				return false;
		} else if (!saidaIntervalo.equals(other.saidaIntervalo))
			return false;
		return true;
	}

}
