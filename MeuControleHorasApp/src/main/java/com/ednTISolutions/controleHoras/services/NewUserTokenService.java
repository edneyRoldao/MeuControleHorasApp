package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.models.NewUserToken;
import com.ednTISolutions.controleHoras.repositories.NewUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by edneyroldao on 21/05/17.
 */
@Service
@Transactional
public class NewUserTokenService {

    @Autowired
    private NewUserTokenRepository repository;

    public NewUserToken saveTokenObj(NewUserToken tokenObj) {
        return repository.save(tokenObj);
    }

    public NewUserToken retrieveTokenFromSerial(String serial) {
        return repository.findBySerial(serial);
    }

    public void removeTokenNewUserValidation(String serial) {
        NewUserToken token = repository.findBySerial(serial);
        repository.delete(token.getId());
    }

    public String generateSerialFromToken(String token) {
        String serial = removeSpecialCharactersFromToken(token);
        Random random = new Random();
        int num = random.nextInt(serial.length() - 10);
        serial = serial.substring(num, num + 6);

        return serial;
    }

    private String removeSpecialCharactersFromToken(String token) {
        StringBuilder newToken = new StringBuilder();
        Matcher matcher = Pattern.compile("\\w").matcher(token);

        while(matcher.find()) {
            newToken.append(matcher.group());
        }

        return newToken.toString();
    }


}
