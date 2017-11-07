package com.ednTISolutions.controleHoras.repositories;

import java.time.LocalDate;
import java.util.List;

import com.ednTISolutions.controleHoras.models.MarcacaoPonto;

public interface MarcacaoPontoRepository {
	
	List<MarcacaoPonto> list(String profileEmail, LocalDate init, LocalDate end);
	
}
