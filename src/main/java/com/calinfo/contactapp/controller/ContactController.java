package com.calinfo.contactapp.controller;

import com.calinfo.contactapp.repository.ContactRepository;
import com.calinfo.contactapp.model.Contact;
import com.calinfo.contactapp.model.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController
{
    @Autowired
    private ContactRepository repository;

    public ContactController(ContactRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/all")
    public @ResponseBody List <Contact> all()
    {
        return repository.findAll();
    }

    @GetMapping()
    public @ResponseBody ContactDTO getContactByFirstName(@RequestParam("firstName")String first_name)
    {
        ContactDTO c = repository.findByFirstName(first_name);
        System.out.println(c.getFirstName());
        return repository.findByFirstName(first_name);
    }
}
