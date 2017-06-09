package com.ednTISolutions.controleHoras.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.models.UserProfile;
import com.ednTISolutions.controleHoras.repositories.UserProfileRepository;

@Service
@Transactional
public class UserProfileService {

	@Autowired
	private UserProfileRepository repository;

	public UserProfile createNewProfile(User user) {
		return repository.save(UserProfile.createProfile(user.getFirstname(), user.getUsername()));
	}

	public UserProfile getUserProfile(String email) {
		return repository.findByEmail(email);
	}

}
