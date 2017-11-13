package com.ednTISolutions.controleHoras.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ednTISolutions.controleHoras.models.RegistroPonto;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.services.RegistroPontoService;

@RestController
@RequestMapping("registros")
public class RegistroPontoController {

	@Autowired
	private RegistroPontoService service;
	
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping
    @PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<RegistroPonto>> registrosMesAtual(HttpServletRequest request) {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        String email = jwtTokenUtil.getUsernameFromToken(token);
		List<RegistroPonto> registros = service.listarRegistros(email);
		
		if(registros == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.ok(registros);
	}

	
	@GetMapping("anteriores/{params}")
    @PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<RegistroPonto>> registros(@PathVariable("params") String params) {
		String[] parametros = params.split(",");
		
		String email = parametros[0];
		LocalDate init = getDataInicio(parametros);
		LocalDate fim = getDataFim(parametros);
		
		List<RegistroPonto> registros = service.listarRegistros(email, init, fim);
		
		if(registros == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.ok(registros);
	}
	
	private LocalDate getDataInicio(String[] params) {
		int ano = Integer.parseInt(params[1]);
		int mes = Integer.parseInt(params[2]);
		int dia = Integer.parseInt(params[3]);
		return LocalDate.of(ano, mes, dia);
	}
	
	private LocalDate getDataFim(String[] params) {
		int ano = Integer.parseInt(params[4]);
		int mes = Integer.parseInt(params[5]);
		int dia = Integer.parseInt(params[6]);
		return LocalDate.of(ano, mes, dia);		
	}
	
}
