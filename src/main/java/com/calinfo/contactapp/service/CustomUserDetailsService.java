package com.calinfo.contactapp.service;

import com.calinfo.contactapp.model.User;
import com.calinfo.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s);
        if(user == null)
        {
            throw new UsernameNotFoundException(s);
        }
        return new CustomPrincipalUser(user);
    }
}
