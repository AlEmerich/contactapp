package com.calinfo.contactapp.controller;

import com.calinfo.contactapp.model.User;
import com.calinfo.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserRepository repository;

    public UserController(UserRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/all")
    public @ResponseBody List<User> all()
    {
        return repository.findAll();
    }
}
