package com.mirea.practice5.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;
}