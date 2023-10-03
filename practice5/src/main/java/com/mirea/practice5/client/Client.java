package com.mirea.practice5.client;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String name;
        private String email;
        private String login;
        private String password;
}