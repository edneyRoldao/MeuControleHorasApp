package com.ednTISolutions.controleHoras.test;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.utils.JwtTokenUtil;
import com.ednTISolutions.controleHoras.security.utils.JwtUserFactory;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by edneyroldao on 19/06/17.
 */
public class TokenUtilTest {

    @Test
    public void mustGenerateTokenCorrectly() {
        // first step: create mass data
        JwtTokenUtil tokenUtil = new JwtTokenUtil();

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, RoleType.ROLE_ADMIN));

        User user = new User();
        user.setFirstname("Marjorie");
        user.setUsername("marjorie@gmail.com");
        user.setPassword("admin");
        user.setLastPasswordResetDate(null);
        user.setEnabled(true);
        user.setAuthorities(roles);

        UserDetails userDetails = JwtUserFactory.create(user);

        // second step: Process data
        String token = tokenUtil.generateToken(userDetails);
        String username = tokenUtil.getUsernameFromToken(token);

        // third step: test
        assertEquals("retrieve username from token", user.getUsername(), username);
    }

}
