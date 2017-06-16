package com.ednTISolutions.controleHoras.security.services;

import com.ednTISolutions.controleHoras.services.UserService;
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

	@Autowired
    private UserService userService;

	public UserProfile createNewProfile(User user) {
		UserProfile userProfile = UserProfile.createProfile(user.getFirstname(), user.getUsername());
		return repository.save(userProfile);
	}

	public UserProfile findProfile(String email) {
		return repository.findByEmail(email);
    }

	public UserProfile getUserProfile(String email) {
        UserProfile userProfile = findProfile(email);

        if(userProfile == null) {
            User user = userService.findByUsername(email);
            userProfile = createNewProfile(user);
        }

        return userProfile;
    }

}
