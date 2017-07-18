package com.ednTISolutions.controleHoras.repositories.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by edneyroldao on 18/07/17.
 */
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

	@Autowired
	private MongoOperations mongoOp;

	@Override
	public Profile createNewProfile(User user) {
		Profile profile = findProfile(user.getUsername());
		
		if(profile != null)
			return profile;
		
		profile = new Profile(user);
		mongoOp.insert(profile);
		profile = findProfile(user.getUsername());
		
		return profile;
	}

	@Override
	public Profile findProfile(BigInteger id) {
		return mongoOp.findById(id, Profile.class);
	}
	
	@Override
	public Profile findProfile(String email) {
		return mongoOp.findOne(query(where("email").is(email)), Profile.class);
	}

}
