package com.ednTISolutions.controleHoras.repositories.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

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

		if(profile != null) {
			return profile;			
		}
		
		mongoOp.insert(new Profile(user));

		return findProfile(user.getUsername());
	}

	@Override
	public Profile findProfile(BigInteger id) {
		return mongoOp.findById(id, Profile.class);
	}
	
	@Override
	public Profile findProfile(String email) {
		//removeCollection();
		return mongoOp.findOne(query(where("email").is(email)), Profile.class);
	}

	@Override
	public void removeCollection() {
		mongoOp.dropCollection(Profile.class);
	}

}
