package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import com.ednTISolutions.controleHoras.models.Token;
import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.repositories.RoleRepository;
import com.ednTISolutions.controleHoras.repositories.UserRepository;
import com.ednTISolutions.controleHoras.utils.TokenUtil;
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

	@Autowired
	private TokenService tokenService;

	@Autowired
    private TokenUtil tokenUtil;

	@Autowired
    private MailService mailService;


	public User createUser(User user) {
		// Manage error when the use already exists.
		User newUser = findUserByEmail(user.getEmail());
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

	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
    public boolean isUserCreatedBefore(String userEmail) {
	    return repository.findByEmail(userEmail) != null;
    }

    public Token saveConfirmationToken(String token) {
	    String serial = tokenUtil.generateSerialFromToken(token);
	    return tokenService.saveTokenObj(new Token(serial, token));
    }

    public void saveNewPassowrd(User user) {
		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
    	repository.save(user);
    }
    
    public boolean sendEmailNewPassword(User user) {
    	String subject = "envio da nova senha";
    	StringBuilder content = new StringBuilder();
    	content.append("Está é sua nova senha, recomendamos que você altere essa senha na edição do seu perfil.");
    	content.append("\n\n");
    	content.append(user.getPassword());
    	
    	return mailService.sendEmailToUser(user.getEmail(), subject, content.toString());
    }
    
    public boolean sendEmailToNewUser(User user, String serial) {
	    String subject = "Envio de código de ativação de usuário";

        StringBuilder content = new StringBuilder();
        content.append("Para confirmar seu cadastro e começar a usar meuControleHoras App, \n informe o código " +
                       "abaixo na aplicação");
        content.append("\n \n");

        String serialFormatted = "";

        for(int i = 0; i < serial.length(); i++) {
            serialFormatted += Character.toString(serial.charAt(i)) + "  ";
        }

        content.append(serialFormatted);
        content.append("\n \n");
        content.append("http://localhost:8083/MeuControleHoras/#/activate");

        return mailService.sendEmailToUser(user.getEmail(), subject, content.toString());
    }

}
