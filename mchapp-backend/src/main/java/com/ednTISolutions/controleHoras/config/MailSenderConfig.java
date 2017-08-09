package com.ednTISolutions.controleHoras.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by edneyroldao on 15/05/17.
 */
@Configuration
@PropertySource("classpath:mail.properties")
public class MailSenderConfig {

	@Autowired
	private Environment env;

	@Bean
	public MailSender mailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();

		sender.setHost(env.getProperty("mch.mail.host"));
		sender.setPort(Integer.parseInt(env.getProperty("mch.mail.port")));
		sender.setProtocol(env.getProperty("mch.mail.protocol"));
		sender.setUsername(env.getProperty("mch.mail.username"));
		sender.setPassword(env.getProperty("mch.mail.password"));
		sender.setJavaMailProperties(getProperties());

		return sender;
	}

	private Properties getProperties() {
		Properties prop = new Properties();

		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.quitwait", true);

		return prop;
	}

}
