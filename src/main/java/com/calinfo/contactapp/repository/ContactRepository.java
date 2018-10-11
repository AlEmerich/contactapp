package com.calinfo.contactapp.repository;

import com.calinfo.contactapp.model.Contact;
import com.calinfo.contactapp.model.ContactDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select new com.calinfo.contactapp.model.ContactDTO(c.firstName, c.lastName, c.mail) from Contact c where c.firstName = ?1")
    ContactDTO findByFirstName(String firstName);
}
