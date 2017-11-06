package com.ednTISolutions.controleHoras.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ednTISolutions.controleHoras.models.NewUserTemp;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.UserRepository;
import com.ednTISolutions.controleHoras.security.utils.PasswordUtil;
import com.ednTISolutions.controleHoras.security.utils.SerialGenerator;

/**
 * Created by edneyroldao on 07/06/17.
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MailService mailService;

	@Autowired
	private NewUserTempService tokenService;

	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public User createUser(User user) {
		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
		// user.setAuthorities(roleService.addRolesByRoleType(RoleType.ROLE_USER));
		user.setAuthorities(roleService.addAllRoles());
		user.setEnabled(true);
		user.setLastPasswordResetDate(new Date());

		return repository.save(user);
	}

	public boolean isUserCreatedBefore(String username) {
		return repository.findByUsername(username) != null;
	}

	public NewUserTemp saveConfirmationToken(String token) {
		String serial = SerialGenerator.generateSerial(6);
		return tokenService.saveTokenObj(new NewUserTemp(serial, token));
	}

	public void saveNewPassowrd(User user) {
		String password = PasswordUtil.encodePassword(user.getPassword());
		user.setPassword(password);
		user.setLastPasswordResetDate(new Date());		
		repository.save(user);
	}

	public boolean sendEmailNewPassword(User user) {
		String subject = "envio da nova senha";
		StringBuilder content = new StringBuilder();
		content.append("Está é sua nova senha, recomendamos que você altere essa senha na edição do seu perfil.");
		content.append("\n\n");
		content.append(user.getPassword());

		return mailService.sendEmailToUser(user.getUsername(), subject, content.toString());
	}

	public boolean sendEmailToNewUser(User user, String serial) {
		String subject = "Envio de código de ativação de usuário";

		StringBuilder content = new StringBuilder();
		content.append("Para confirmar seu cadastro e começar a usar meuControleHoras App, \n informe o código "
				+ "abaixo na aplicação");
		content.append("\n \n");

		content.append(serial);
		content.append("\n \n");
		content.append("http://localhost:8083/#/ativarConta");

		return mailService.sendEmailToUser(user.getUsername(), subject, content.toString());
	}

}
