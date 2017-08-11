package com.ednTISolutions.controleHoras.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ednTISolutions.controleHoras.exceptions.ProfileUsernameEmptyException;
import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;

	public Profile create(User user) {
		repository.save(user);
		return find(user.getUsername());
	}
	
	public Profile find(String email) {
		return repository.find(email);
	}
	
	public Profile update(Profile profile) throws ProfileUsernameEmptyException {
		if(isEmailAndNameEmpty(profile)) {
			String msg = "It's not allowed update profile with name or email empty";
			throw new ProfileUsernameEmptyException(msg);
		}
			
		repository.delete(profile.getEmail());
		repository.save(profile);
		
		return repository.find(profile.getId());
	}
	
	private boolean isEmailAndNameEmpty(Profile profile) {
		return StringUtils.isEmpty(profile.getName()) || StringUtils.isEmpty(profile.getEmail());
	}
	
	

}
