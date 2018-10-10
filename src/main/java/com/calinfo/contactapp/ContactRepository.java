package com.calinfo.contactapp;

import com.calinfo.contactapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAll();

}
