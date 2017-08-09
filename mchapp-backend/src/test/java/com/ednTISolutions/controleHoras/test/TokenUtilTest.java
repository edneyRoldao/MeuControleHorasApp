package com.ednTISolutions.controleHoras.test;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.security.utils.JwtUserFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by edneyroldao on 19/06/17.
 */
public class TokenUtilTest {

	private JwtTokenUtil tokenUtil;
	private User user;

	@Before
	@SuppressWarnings("resource")
	public void createAbjectFromSpringContext() {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(JwtTokenUtil.class);
		ctx.refresh();
		this.tokenUtil = (JwtTokenUtil) ctx.getBean("jwtTokenUtil");
	}

	@Before
	public void getUser() {
		List<Role> roles = new ArrayList<>();
		roles.add(new Role(1L, RoleType.ROLE_ADMIN));

		User user = new User();
		user.setFirstname("Marjorie");
		user.setUsername("marjorie@gmail.com");
		user.setPassword("admin");
		user.setLastPasswordResetDate(null);
		user.setEnabled(true);
		user.setAuthorities(roles);

		this.user = user;
	}

	@Test
	public void mustGenerateTokenCorrectly() {
		UserDetails userDetails = JwtUserFactory.create(this.user);
		String token = tokenUtil.generateToken(userDetails);
		String username = tokenUtil.getUsernameFromToken(token);

		assertEquals("retrieve username from token", user.getUsername(), username);
	}

	@Test
	public void mustCheckWhetherIsTokenValid() {
		UserDetails userDetails = JwtUserFactory.create(user);
		String token = tokenUtil.generateToken(userDetails);

		assertTrue(tokenUtil.validateToken(token, userDetails));
	}

	@Test
	public void mustGenerateTokenForNewUsers() {
		User newUser = new User();
		newUser.setUsername("nadine@gmail.com");
		newUser.setPassword("admin");
		newUser.setFirstname("Vitoria Nadine");

		String token = tokenUtil.generateTokenFromNewUser(newUser);
		User user = tokenUtil.getNewUserFromToken(token);

		assertEquals("Retrieve the user", user, newUser);
	}

}
