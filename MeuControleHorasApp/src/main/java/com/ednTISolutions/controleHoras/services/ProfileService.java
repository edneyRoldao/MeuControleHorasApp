package com.ednTISolutions.controleHoras.services;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;

	public Profile getProfile(BigInteger id) {
        return repository.findProfile(id);
    }
	
	public Profile createProfile(User user) {
		return repository.createNewProfile(user);
	}

}
