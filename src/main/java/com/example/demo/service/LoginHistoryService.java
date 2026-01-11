package com.example.demo.service;

import com.example.demo.model.LoginHistory;
import com.example.demo.repository.LoginHistoryRepository;
import com.example.demo.security.CustomUserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public LoginHistoryService( LoginHistoryRepository loginHistoryRepository) {
        this.loginHistoryRepository = loginHistoryRepository;
    }

    public void save(CustomUserDetails user, String token) {
        LoginHistory history = new LoginHistory();
        history.setUserid(user.getId());
        history.setEmail(user.getEmail());
        history.setAcessToken( token );
        loginHistoryRepository.save( history );
    }
}
