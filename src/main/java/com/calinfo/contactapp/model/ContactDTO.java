package com.calinfo.contactapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String mail;

    public ContactDTO()
    {
        // empty
    }

    public ContactDTO(long id, String f, String l, String m)
    {
        this.id = id;
        this.firstName = f;
        this.lastName = l;
        this.mail = m;
    }
}
