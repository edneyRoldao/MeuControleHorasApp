package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.RoleRepository;
import com.ednTISolutions.controleHoras.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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

	@Autowired
	private MailSender mailSender;


	public User createUser(User user) {
		
		// Manage error when the use already exists.
		User newUser = repository.findByEmail(user.getEmail());
		if(newUser != null)
		    return null;

		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));

		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByType(RoleType.ROLE_USER));
		user.setRoles(roles);

	    return repository.save(user);
    }

    public boolean isUserCreatedBefore(String userEmail) {
	    return repository.findByUsername(userEmail) != null;
    }

    public String createURLNewUser(String token) {
        return "http://localhost:8083/MeuControleHoras/usuario/" + token;
    }

    public boolean sendEmailToNewUser(User user, String url) {
        SimpleMailMessage message = new SimpleMailMessage();

        StringBuilder sb = new StringBuilder();
        sb.append("Para confirmar seu cadastro e começar a usar meuControleHoras App, \n click no link abaixo:");
        sb.append("\n");
        sb.append(url);

        message.setFrom("meucontrolehoras@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Confirmação de cadastro de usuário");
        message.setText(sb.toString());

        mailSender.send(message);

        return true;
    }

}
