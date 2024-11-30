package com.example.RealTimeDocumentEditApplication.authentication.controller;

import com.example.RealTimeDocumentEditApplication.authentication.dto.ApiResponseDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignInRequestDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignUpRequestDto;
import com.example.RealTimeDocumentEditApplication.authentication.services.AuthService;
import com.example.RealTimeDocumentEditApplication.authentication.exception.RoleNotFoundException;
import com.example.RealTimeDocumentEditApplication.authentication.exception.UserAlreadyExistsException;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto<?>> registerUser(@RequestBody @Valid SignUpRequestDto signUpRequestDto)
            throws UserAlreadyExistsException, RoleNotFoundException, RoleNotFoundException {
        return authService.signUpUser(signUpRequestDto);
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponseDto<?>> signInUser(@RequestBody @Valid SignInRequestDto signInRequestDto){
        return authService.signInUser(signInRequestDto);
    }
}
