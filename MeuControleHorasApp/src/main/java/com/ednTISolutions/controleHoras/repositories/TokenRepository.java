package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by edneyroldao on 21/05/17.
 */
public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findBySerial(String serial);

}
