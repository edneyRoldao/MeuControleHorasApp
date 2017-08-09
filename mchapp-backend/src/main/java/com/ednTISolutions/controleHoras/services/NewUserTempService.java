package com.ednTISolutions.controleHoras.services;

import com.ednTISolutions.controleHoras.models.NewUserTemp;
import com.ednTISolutions.controleHoras.repositories.NewUserTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by edneyroldao on 21/05/17.
 */
@Service
@Transactional
public class NewUserTempService {

    @Autowired
    private NewUserTempRepository repository;

    public NewUserTemp saveTokenObj(NewUserTemp tokenObj) {
        return repository.save(tokenObj);
    }

    public NewUserTemp retrieveUserTempFromSerial(String serial) {
        return repository.findBySerial(serial);
    }

    public void deleteTemporaryUser(String serial) {
        NewUserTemp newUser = repository.findBySerial(serial);
        repository.delete(newUser.getId());
    }

}
