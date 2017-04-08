package com.ednTISolutions.controleHoras.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> list() {
		return repository.findAll();
	}
	
}
