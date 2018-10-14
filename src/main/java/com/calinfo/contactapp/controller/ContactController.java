package com.calinfo.contactapp.controller;

import com.calinfo.contactapp.model.AppUser;
import com.calinfo.contactapp.repository.ContactRepository;
import com.calinfo.contactapp.model.Contact;
import com.calinfo.contactapp.model.ContactDTO;
import com.calinfo.contactapp.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController
{
    @Autowired
    private ContactRepository repository;

    @Autowired
    private UserRepository userRepository;

    public ContactController(ContactRepository repository)
    {
        this.repository = repository;
    }

    private AppUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return this.userRepository.findByUsername(auth.getPrincipal().toString());
    }

    @GetMapping("/all")
    public @ResponseBody List <ContactDTO> all()
    {
        AppUser current = this.getCurrentUser();

        List<Contact> l = this.repository.findAll();
        List<ContactDTO> res = new ArrayList<>();
        for(Contact c: l)
            if(current.getUser_id() == c.getOwner().getUser_id())
                res.add(new ContactDTO(c.getId(), c.getFirstName(),
                        c.getLastName(), c.getMail()));
        return res;
    }

    @GetMapping(params = "firstName")
    public @ResponseBody ContactDTO getContactByFirstName(@RequestParam("firstName") String first_name)
    {
        ContactDTO c = repository.findByFirstName(first_name);
        if(c == null)
            throw new ObjectNotFoundException(null, "No contact with first name " + first_name);
        return repository.findByFirstName(first_name);
    }

    @GetMapping(params = "id")
    public @ResponseBody ContactDTO getContactById(@RequestParam("id") long id)
    {
        Optional<Contact> c = repository.findById(id);
        if(!c.isPresent())
            throw new ObjectNotFoundException(c.get(), "No contact with id " + id);
        return new ContactDTO(c.get().getId(), c.get().getFirstName(), c.get().getLastName(), c.get().getMail());
    }

    @DeleteMapping()
    public @ResponseBody void deleteContact(@RequestParam("id") long id)
    {
        this.repository.deleteById(id);
    }

    @PostMapping()
    public @ResponseBody ContactDTO postContact(@RequestBody ContactDTO contactDTO)
    {
        Contact c = new Contact(contactDTO.getFirstName(),
                contactDTO.getLastName(),
                contactDTO.getMail(),
                this.getCurrentUser());
        this.repository.save(c);
        return contactDTO;
    }

    @PutMapping()
    public @ResponseBody ResponseEntity<Object> updateContact(
            @RequestBody ContactDTO contactDTO,
            @RequestParam("id") long id)
    {
        Optional<Contact> optC = this.repository.findById(id);
        if(!optC.isPresent())
            return ResponseEntity.notFound().build();

        Contact c = optC.get();
        c.setId(id);
        c.setDTO(contactDTO, this.getCurrentUser());
        this.repository.save(c);
        return ResponseEntity.noContent().build();
    }
}
