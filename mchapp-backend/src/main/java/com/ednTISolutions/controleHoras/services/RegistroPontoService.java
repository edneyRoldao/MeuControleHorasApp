package com.ednTISolutions.controleHoras.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ednTISolutions.controleHoras.models.RegistroPonto;
import com.ednTISolutions.controleHoras.repositories.RegistroPontoRepository;

@Service
public class RegistroPontoService {

	@Autowired
	private RegistroPontoRepository repository;

	public List<RegistroPonto> listarRegistros(String email, LocalDate dataInicial, LocalDate dataFinal) {
		return repository.list(email, dataInicial, dataFinal);
	}
	
	/**
	 * @param email from userProfile
	 * @return the first day from current month to now
	 */
	public List<RegistroPonto> listarRegistros(String email) {
		LocalDate dataFinal = LocalDate.now();
		LocalDate dataInicial = dataFinal.withDayOfMonth(1);
		
		return repository.list(email, dataInicial, dataFinal);
	}


}
