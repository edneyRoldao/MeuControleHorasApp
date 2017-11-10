package com.ednTISolutions.controleHoras.repositories;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.ednTISolutions.controleHoras.models.RegistroPonto;

public interface RegistroPontoRepository {
	
	void save(RegistroPonto registro);
	
	RegistroPonto find(BigInteger id);

	RegistroPonto find(String profileEmail, LocalDate registro);
	
	void deleteRegistro(String profileEmail, LocalDate registro);
	
	void deleteCollection();
	
	List<RegistroPonto> list(String profileEmail, LocalDate init, LocalDate end);
	
}
