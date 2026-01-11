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

    public LoginHistory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    public LocalDateTime getLoginAt() {
        return LoginAt;
    }

    public void setLoginAt(LocalDateTime loginAt) {
        LoginAt = loginAt;
    }
}
