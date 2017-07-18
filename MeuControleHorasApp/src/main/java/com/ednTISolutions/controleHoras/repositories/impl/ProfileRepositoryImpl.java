package com.ednTISolutions.controleHoras.repositories.impl;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by edneyroldao on 18/07/17.
 */
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    @Override
    public void createNewProfile(User user) {

    }

    @Override
    public Profile findProfile(String email) {
        return null;
    }

    @Override
    public Profile findProfile(BigInteger id) {
        return null;
    }

}
