package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    String getPasswordByUsername(String username);
    void save(User user);
}
