package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.UserRepository;
import com.ednTISolutions.controleHoras.utils.UserDetailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by edneyroldao on 28/04/17.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
            return UserDetailUtil.create(user);
        }
    }

}
