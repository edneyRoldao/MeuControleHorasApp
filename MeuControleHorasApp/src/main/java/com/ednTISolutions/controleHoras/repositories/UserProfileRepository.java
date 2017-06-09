package com.ednTISolutions.controleHoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ednTISolutions.controleHoras.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	UserProfile findByEmail(String email);
	
}
