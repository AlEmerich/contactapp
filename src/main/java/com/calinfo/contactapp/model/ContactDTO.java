package com.calinfo.contactapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactDTO {

    private String firstName;
    private String lastName;
    private String mail;

    public ContactDTO(String f, String l, String m)
    {
        this.firstName = f;
        this.lastName = l;
        this.mail = m;
    }
}
