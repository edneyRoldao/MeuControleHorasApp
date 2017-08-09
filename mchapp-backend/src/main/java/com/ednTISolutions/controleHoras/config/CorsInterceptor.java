package com.ednTISolutions.controleHoras.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CorsInterceptor extends HandlerInterceptorAdapter{

	private static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
	private static final String METHODS_NAME = "Access-Control-Allow-Methods";
	private static final String HEADERS_NAME = "Access-Control-Allow-Headers";
		 
	 @Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		res.setHeader(ORIGIN_NAME, "http://localhost:3030");
		res.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
		res.setHeader(HEADERS_NAME, "Origin, X-Requested-With, X-Auth-Token, Content-Type, Accept");

		return true;
	}

}
