package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;

import java.math.BigInteger;

public interface ProfileRepository {

	void createNewProfile(User user);

	Profile findProfile(String email);

	Profile findProfile(BigInteger id);

}
