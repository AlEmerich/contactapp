package com.calinfo.contactapp.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Contact implements java.io.Serializable
{
    @Id @GeneratedValue
    private Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String mail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private @NonNull User owner;

    public Contact()
    {

    }
    public Contact(String firstName, String lastName, String mail, User owner)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.owner = owner;
    }
}
