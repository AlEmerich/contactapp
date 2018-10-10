package com.calinfo.contactapp.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact implements java.io.Serializable{
    @Id @GeneratedValue
    private Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String mail;
}
