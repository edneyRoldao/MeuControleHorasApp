package com.ednTISolutions.controleHoras.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;

	public Profile getUserProfile(User user) {
        return findOrCreateProfile(user);
    }

	private Profile findOrCreateProfile(User user) {
        Profile profile = repository.findProfile(user.getUsername());

        if(profile != null)
            return profile;

        repository.createNewProfile(user);

		return repository.findProfile(user.getUsername());
    }

}
