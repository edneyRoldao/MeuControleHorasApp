package com.ednTISolutions.controleHoras.repositories.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.ednTISolutions.controleHoras.models.Profile;
import com.ednTISolutions.controleHoras.repositories.ProfileRepository;

/**
 * Created by edneyroldao on 18/07/17.
 */
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

	@Autowired
	private MongoOperations mongoOps;

	@Override
	public void save(Profile profile) {
		mongoOps.insert(profile);
	}

	@Override
	public Profile find(String email) {
		return mongoOps.findOne(query(where("email").is(email)), Profile.class);
	}

	@Override
	public Profile find(BigInteger id) {
		return mongoOps.findOne(query(where("id").is(id)), Profile.class);
	}

	@Override
	public void delete(String email) {
		mongoOps.remove(query(where("email").is(email)), Profile.class);
	}

	@Override
	public void deleteCollection() {
		mongoOps.dropCollection(Profile.class);
	}

}
