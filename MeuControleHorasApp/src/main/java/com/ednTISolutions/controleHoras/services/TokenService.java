package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.models.Token;
import com.ednTISolutions.controleHoras.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by edneyroldao on 21/05/17.
 */
@Service
@Transactional
public class TokenService {

    @Autowired
    private TokenRepository repository;

    public Token saveTokenObj(Token tokenObj) {
        return repository.save(tokenObj);
    }

    public Token retrieveTokenFromSerial(String serial) {
        return repository.findBySerial(serial);
    }

    public void removeTokenNewUserValidation(String serial) {
        Token token = repository.findBySerial(serial);
        repository.delete(token.getId());
    }

}
