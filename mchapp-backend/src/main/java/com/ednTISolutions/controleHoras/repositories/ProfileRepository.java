package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.Profile;

import java.math.BigInteger;

public interface ProfileRepository {

	void save(Profile profile);

	Profile find(String email);
	
	Profile find(BigInteger id);

	void delete(String email);
	
	void deleteCollection();

}
