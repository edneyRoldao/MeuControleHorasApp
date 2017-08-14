package com.ednTISolutions.controleHoras.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ednTISolutions.controleHoras.exceptions.ProfileUsernameEmptyException;
import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

@Service
@PropertySource("classpath:avatar.properties")
public class ProfileService {

	@Autowired
	private ProfileRepository repository;
	
	@Autowired
	private Environment env;

	public Profile create(User user) {
		Profile profile = new Profile(user);
		profile.setAvatar(env.getProperty("avatar"));
		repository.save(profile);
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
