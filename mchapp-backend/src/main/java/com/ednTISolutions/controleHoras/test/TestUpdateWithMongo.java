package com.ednTISolutions.controleHoras.test;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.ednTISolutions.controleHoras.config.MongodbConfig;
import com.ednTISolutions.controleHoras.models.Address;
import com.ednTISolutions.controleHoras.models.Profile;

public class TestUpdateWithMongo {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongodbConfig.class);
		MongoOperations mongo = (MongoOperations) ctx.getBean("mongoTemplate");
		System.out.println("Mongo operations object has been retrieved from spring context !");		
		mongo.dropCollection("profiles");
		
		Profile insertedProf = createProfile();
		mongo.insert(insertedProf);
		Profile foundProfile = mongo.findOne(query(where("email").is(insertedProf.getEmail())), Profile.class);
		Profile updatedProfile = updateProfile(foundProfile);
		Profile foundProfile2 = mongo.findOne(query(where("email").is(updatedProfile.getEmail())), Profile.class);
		foundProfile2 = updatedProfile;		
		mongo.save(foundProfile2);		
	}
	
	public static Profile updateProfile(Profile p) {
		Address a = new Address();
		a.setBairro("Vila Cachoeira");
		a.setCep("02343030");
		a.setCidade("Sao Paulo");
		a.setLogradouro("Rua mere marie");
		a.setNumberAndComplement("472 apto 08");
		a.setUf("SP");
		
		p.setAddress(a);
		p.setAvatar("scasdfasdfasdfasdfasdfasdfasdflldjajshnaskdfajksdhfadfasdjj");
		p.setName("edney roldao");
		p.setEmail("edneyroldao@gmail.com");
		p.setBirthDate("10/05/1982");
		p.setCompany("Marisa");
		p.setHorasPorMes(180);
		p.setGender('M');
		p.setMaxHorasPorMes(180);
		p.setValorHora(new BigDecimal(56.88));

		return p;
	}
	
	public static Profile createProfile() {
		Profile p = new Profile();
		p.setAddress(new Address());
		p.setName("edney roldao");
		p.setEmail("edneyroldao@gmail.com");
		
		return p;
	}
	
}
