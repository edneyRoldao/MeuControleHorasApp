package com.ednTISolutions.controleHoras.test;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
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
		populaBanco(mongo);
		
		String email = "edneyroldao@gmail.com.br";
		LocalDate dataFinal = LocalDate.now();
		LocalDate dataInicial = dataFinal.withDayOfMonth(1);
		
		System.out.println("######################################################");
		System.out.println("######################################################");
		System.out.println("######################################################");
		System.out.println("######################################################");
		System.out.println("######################################################");		
		list(mongo, email, dataInicial, dataFinal).forEach(r -> System.out.println(r.getDataRegistro()));
		
	}
	
	public static List<RegistroPonto> list(MongoOperations ops, String profileEmail, LocalDate init, LocalDate end) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").gte(init).lte(end));
		return ops.find(query, RegistroPonto.class);
	}
	
	public static RegistroPonto find(MongoOperations ops, String profileEmail, LocalDate registro) {
		Query query = query(where("profileEmail").is(profileEmail).and("dataRegistro").is(registro));
		return ops.findOne(query, RegistroPonto.class);
	}
	
	public static void populaBanco(MongoOperations ops) {
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 1), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 2), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 3), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 4), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 5), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 6), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 7), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 8), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 9), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 10), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 11), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 12), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 13), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 14), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 15), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 16), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 17), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 18), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 19), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 20), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 21), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 22), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 23), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 24), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 25), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 26), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 27), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 28), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 29), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 30), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 31), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 1), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 2), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 3), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 4), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 5), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 6), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 7), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 8), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 9), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 10), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 11), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 12), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 13), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 14), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 15), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 16), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 17), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 18), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 19), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 1, 20), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 21), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 22), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 23), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 24), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 25), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 26), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 27), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 2, 28), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 3, 1), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 3, 2), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 3, 3), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));

		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 1), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 2), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 3), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 4), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 5), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 6), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 7), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 8), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 9), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 10), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 11), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 12), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
		ops.save(new RegistroPonto("edneyroldao@gmail.com.br", LocalDate.of(2017, 11, 13), new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(13,  20), LocalTime.of(18, 40)))));
	}


	
}
