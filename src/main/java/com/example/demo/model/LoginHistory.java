package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table( name = "login History")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userid;

    private String email;

    private String acessToken;

    @CreationTimestamp
    private LocalDateTime LoginAt;

    public LoginHistory(Long userid, String email, String acessToken, LocalDateTime LoginAt) {
        this.userid = userid;
        this.email = email;
        this.acessToken = acessToken;
    }
}
