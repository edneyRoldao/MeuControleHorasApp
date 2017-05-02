package com.ednTISolutions.controleHoras.util;

import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.UserDetailImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by edneyroldao on 30/04/17.
 */
public class UserDetailFactory {

    private UserDetailFactory() {}

    public static UserDetailImpl create(User user) {
        UserDetailImpl userDetail = new UserDetailImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                null,
                null,
                getGrantedAuthorities(user.getRoles())
        );

        return userDetail;
    }

    private static List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getType().name()))
                .collect(Collectors.toList());
    }

}
