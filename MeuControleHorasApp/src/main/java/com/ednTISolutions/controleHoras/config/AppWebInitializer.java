package com.ednTISolutions.controleHoras.config;

import com.ednTISolutions.controleHoras.security.config.AppWebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]
			{
				DatasourceConfig.class,
				AppWebSecurityConfig.class,
				AppWebConfig.class,
				MailSenderConfig.class,
				MongodbConfig.class
			};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}
