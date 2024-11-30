package com.example.demo;

import com.example.demo.exception.RoleNotFoundException;
import com.example.demo.exception.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    ResponseEntity<ApiResponseDto<?>> signUpUser(SignUpRequestDto signUpRequestDto) throws UserAlreadyExistsException, RoleNotFoundException;

    ResponseEntity<ApiResponseDto<?>> signInUser(SignInRequestDto signInRequestDto);
}
