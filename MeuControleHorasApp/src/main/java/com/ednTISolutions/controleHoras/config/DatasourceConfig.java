package com.ednTISolutions.controleHoras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.ednTISolutions.controleHoras")
public class DatasourceConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase database = builder.setType(EmbeddedDatabaseType.HSQL).build();
		
		return database;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.HSQL);
		adapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("com.ednTISolutions.controleHoras");
		factory.setDataSource(dataSource());
		factory.setJpaProperties(hibernateProperties());
		
		return factory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}

	@Bean
	@Lazy(false)
	public ResourceDatabasePopulator populateDatabase() throws SQLException {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("popula-database.sql"));
		Connection con = null;

		try {
			con = DataSourceUtils.getConnection(dataSource());
			populator.populate(con);
		} finally {
			if(con != null)
				DataSourceUtils.releaseConnection(con, dataSource());
		}

		return populator;
	}
	
	private Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		return props;
	}

}
