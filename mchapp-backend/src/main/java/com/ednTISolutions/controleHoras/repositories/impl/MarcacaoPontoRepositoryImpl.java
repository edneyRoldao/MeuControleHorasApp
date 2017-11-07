package com.ednTISolutions.controleHoras.repositories.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ednTISolutions.controleHoras.models.MarcacaoPonto;
import com.ednTISolutions.controleHoras.repositories.MarcacaoPontoRepository;

public class MarcacaoPontoRepositoryImpl implements MarcacaoPontoRepository {

	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public List<MarcacaoPonto> list(String profileEmail, LocalDate init, LocalDate end) {		
		Query query = new Query();
		query.addCriteria(Criteria.where("profileEmail").is(profileEmail));
		query.addCriteria(Criteria.where("entrada").gte(init).lt(end));		
		return mongoOps.find(query, MarcacaoPonto.class);
	}

}
