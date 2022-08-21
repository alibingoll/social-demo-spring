package com.project.socialDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",length = 50,unique = false)
    private String userName;

    @Column(name = "password",length = 50)
    private String password;
}
