package com.rupp.java.PFM_API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false,length = 50)
    private String username;

    @Column(name = "password", nullable = false,length = 50)
    private String password;

    @Column(name = "email", nullable = false,length = 50)
    private String email;
}
