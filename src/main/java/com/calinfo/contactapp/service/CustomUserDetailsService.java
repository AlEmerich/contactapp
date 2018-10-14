package com.calinfo.contactapp.service;

import com.calinfo.contactapp.model.AppUser;
import org.springframework.security.core.userdetails.User;
import com.calinfo.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;


@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository applicationUserRepository) {
        this.userRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser applicationUser = userRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
