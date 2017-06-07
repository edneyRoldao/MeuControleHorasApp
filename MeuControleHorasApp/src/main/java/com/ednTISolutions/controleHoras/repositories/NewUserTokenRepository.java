package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.NewUserToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by edneyroldao on 21/05/17.
 */
public interface NewUserTokenRepository extends JpaRepository<NewUserToken, Long> {

    NewUserToken findBySerial(String serial);

}
