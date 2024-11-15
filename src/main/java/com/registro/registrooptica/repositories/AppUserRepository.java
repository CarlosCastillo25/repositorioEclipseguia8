package com.registro.registrooptica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.registrooptica.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	public AppUser findByEmail (String email);

}
