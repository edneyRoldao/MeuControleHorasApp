package com.ednTISolutions.controleHoras.repositories;

import com.ednTISolutions.controleHoras.enums.RoleType;
import com.ednTISolutions.controleHoras.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by edneyroldao on 07/05/17.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleType type);

}
