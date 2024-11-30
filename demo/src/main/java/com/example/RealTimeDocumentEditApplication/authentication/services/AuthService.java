package com.example.RealTimeDocumentEditApplication.authentication.services;

import com.example.RealTimeDocumentEditApplication.authentication.dto.ApiResponseDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignInRequestDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignUpRequestDto;
import com.example.RealTimeDocumentEditApplication.authentication.exception.RoleNotFoundException;
import com.example.RealTimeDocumentEditApplication.authentication.exception.UserAlreadyExistsException;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    ResponseEntity<ApiResponseDto<?>> signUpUser(@Valid SignUpRequestDto signUpRequestDto) throws UserAlreadyExistsException, RoleNotFoundException;

    ResponseEntity<ApiResponseDto<?>> signInUser(@Valid SignInRequestDto signInRequestDto);
}
