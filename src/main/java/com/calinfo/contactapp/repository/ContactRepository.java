package com.calinfo.contactapp.repository;

import com.calinfo.contactapp.model.Contact;
import com.calinfo.contactapp.model.ContactDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select new com.calinfo.contactapp.model.ContactDTO(c.id, c.firstName, c.lastName, c.mail) from Contact c where c.firstName = ?1")
    ContactDTO findByFirstName(String firstName);
}
