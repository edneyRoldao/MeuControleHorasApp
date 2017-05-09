package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.RoleRepository;
import com.ednTISolutions.controleHoras.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	public User createUser(User user) {

		User newUser = repository.findByEmail(user.getEmail());

		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));

		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByType(RoleType.ROLE_USER));
		user.setRoles(roles);

	    return repository.save(user);
    }

}
