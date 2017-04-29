package com.ednTISolutions.controleHoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ednTISolutions.controleHoras.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

}
