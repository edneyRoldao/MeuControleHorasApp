package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.models.NewUserTemp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by edneyroldao on 21/05/17.
 */
public interface NewUserTempRepository extends JpaRepository<NewUserTemp, Long> {

    NewUserTemp findBySerial(String serial);

}
