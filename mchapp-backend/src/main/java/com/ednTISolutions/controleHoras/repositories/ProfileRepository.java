package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;

import java.math.BigInteger;

public interface ProfileRepository {
	
	void save(User user);

	void save(Profile profile);

	Profile find(String email);
	
	Profile find(BigInteger id);

	void delete(String email);
	
	void deleteCollection();

}
