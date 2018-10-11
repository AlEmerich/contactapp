package com.calinfo.contactapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    private Long user_id;

    private String username;

    private String password;

    public User(){}

    public User(String u, String p)
    {
        this.username = u;
        this.password = p;
    }
}
