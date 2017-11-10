package com.ednTISolutions.controleHoras.test;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.ednTISolutions.controleHoras.config.MongodbConfig;
import com.ednTISolutions.controleHoras.models.RegistroPonto;

public class TestUpdateWithMongo {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongodbConfig.class);
		MongoOperations mongo = (MongoOperations) ctx.getBean("mongoTemplate");
		System.out.println("Mongo operations object has been retrieved from spring context !");		
		mongo.dropCollection("registroPonto");
		
		RegistroPonto rp1 = new RegistroPonto("edney@gmail.com");
		rp1.getRegistros().add(LocalTime.now());
		
		System.out.println("teste object id antes de insert: " + rp1.getId());		
		mongo.insert(rp1);			
		System.out.println("teste object id depois do insert: " + rp1.getId());		
		
		rp1.setProfileEmail("dsfgsdf");
		mongo.save(rp1);		
	}
	
	public static List<RegistroPonto> list(MongoOperations ops, String profileEmail, LocalDate init, LocalDate end) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").gte(init).lte(end));
		return ops.find(query, RegistroPonto.class);
	}
	
	public static RegistroPonto find(MongoOperations ops, String profileEmail, LocalDate registro) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").is(registro));
		return ops.findOne(query, RegistroPonto.class);
	}


	
}
