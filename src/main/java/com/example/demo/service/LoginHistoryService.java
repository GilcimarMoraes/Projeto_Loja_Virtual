package com.example.demo.service;

import com.example.demo.repository.LoginHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public LoginHistoryService(LoginHistoryRepository loginHistoryRepository) {
        this.loginHistoryRepository = loginHistoryRepository;
    }
}
