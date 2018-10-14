package com.calinfo.contactapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter @Setter
public class AppUser implements Serializable {

    @Id
    @GeneratedValue
    private Long user_id;

    private String username;

    private String password;

    public AppUser(){}

    public AppUser(String u, String p)
    {
        this.username = u;
        this.password = p;
    }
}
