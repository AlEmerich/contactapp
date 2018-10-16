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
    private @NonNull AppUser owner;

    public Contact()
    {
        // empty
    }

    public Contact(String firstName, String lastName, String mail, AppUser owner)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.owner = owner;
    }

    public void setDTO(ContactDTO dto, AppUser owner)
    {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.mail = dto.getMail();
        this.owner = owner;
    }
}
