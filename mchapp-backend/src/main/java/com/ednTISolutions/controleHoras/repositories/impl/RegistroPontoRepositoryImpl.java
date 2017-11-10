package com.ednTISolutions.controleHoras.repositories.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.ednTISolutions.controleHoras.models.RegistroPonto;
import com.ednTISolutions.controleHoras.repositories.RegistroPontoRepository;

/**
 * 
 * @author Edney Roldao - 09/11/17
 *
 */
public class RegistroPontoRepositoryImpl implements RegistroPontoRepository {

	@Autowired
	private MongoOperations mongoOps;

	@Override
	public void save(RegistroPonto registro) {
		mongoOps.insert(registro);
	}

	@Override
	public RegistroPonto find(BigInteger id) {
		return mongoOps.findOne(query(where("id").is(id)), RegistroPonto.class);
	}

	@Override
	public RegistroPonto find(String profileEmail, LocalDate registro) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").is(registro));
		return mongoOps.findOne(query, RegistroPonto.class);
	}

	@Override
	public void deleteRegistro(String profileEmail, LocalDate registro) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").is(registro));
		mongoOps.remove(query, RegistroPonto.class);
	}

	@Override
	public void deleteCollection() {
		mongoOps.dropCollection(RegistroPonto.class);
	}

	@Override
	public List<RegistroPonto> list(String profileEmail, LocalDate init, LocalDate end) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").gte(init).lte(end));
		return mongoOps.find(query, RegistroPonto.class);
	}

}
