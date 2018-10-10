package com.calinfo.contactapp.controller;

import com.calinfo.contactapp.ContactRepository;
import com.calinfo.contactapp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllContactController
{
    @Autowired
    private ContactRepository repository;

    public GetAllContactController(ContactRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List <Contact> all()
    {
        return repository.findAll();
    }
}
