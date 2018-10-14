package com.calinfo.contactapp.controller;

import com.calinfo.contactapp.model.AppUser;
import com.calinfo.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController() {}

    public UserController(UserRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/all")
    public @ResponseBody List<AppUser> all()
    {
        return repository.findAll();
    }


    public UserController(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
