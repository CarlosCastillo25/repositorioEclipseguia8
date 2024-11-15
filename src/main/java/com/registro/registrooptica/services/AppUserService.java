package com.registro.registrooptica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.registro.registrooptica.models.AppUser;
import com.registro.registrooptica.repositories.AppUserRepository;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Use findByEmail method to fetch user from database
        AppUser appUser = repo.findByEmail(email);
        
        // Throw exception if user is not found
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Return Spring Security UserDetails object
        return User.withUsername(appUser.getEmail())
                   .password(appUser.getPassword())
                   .roles(appUser.getRole()) // Ensure role is properly set
                   .build();
    }
}
 
