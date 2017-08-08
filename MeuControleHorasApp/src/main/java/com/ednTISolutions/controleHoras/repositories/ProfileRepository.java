package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;

import java.math.BigInteger;

public interface ProfileRepository {

	Profile createNewProfile(User user);

	Profile findProfile(BigInteger id);

	Profile findProfile(String email);

	void removeCollection();

}
