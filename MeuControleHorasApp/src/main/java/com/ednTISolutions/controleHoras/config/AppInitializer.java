package com.ednTISolutions.controleHoras.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]
			{
				DatasourceConfig.class,
				WebSecurityConfig.class,
				AppWebConfig.class,
				MailSenderConfig.class
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
