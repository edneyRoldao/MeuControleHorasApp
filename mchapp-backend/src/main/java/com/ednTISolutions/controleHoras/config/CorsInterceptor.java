package com.ednTISolutions.controleHoras.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CorsInterceptor extends HandlerInterceptorAdapter{
		 
	 @Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		 res.setHeader("Access-Control-Allow-Credentials", "true");
		 res.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Origin, Accept, Authorization, X-Requested-With, X-Auth-Token, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		 res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, HEAD, OPTIONS");
		 res.setHeader("Access-Control-Allow-Origin", "*");
		 res.setHeader("Access-Control-Max-Age", "1800");
		 
		return super.preHandle(req, res, handler);
	}

}
