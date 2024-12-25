package com.example.RealTimeDocumentEditApplication.authentication.services;

import com.example.RealTimeDocumentEditApplication.authentication.accesscontrol.RoleFactory;
import com.example.RealTimeDocumentEditApplication.authentication.dto.ApiResponseDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignInRequestDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignInResponseDto;
import com.example.RealTimeDocumentEditApplication.authentication.dto.SignUpRequestDto;
import com.example.RealTimeDocumentEditApplication.authentication.exception.RoleNotFoundException;
import com.example.RealTimeDocumentEditApplication.authentication.exception.SignInException;
import com.example.RealTimeDocumentEditApplication.authentication.exception.UserAlreadyExistsException;
import com.example.RealTimeDocumentEditApplication.authentication.models.User;
import com.example.RealTimeDocumentEditApplication.authentication.security.UserDetailsImpl;
import com.example.RealTimeDocumentEditApplication.authentication.security.jwt.JwtUtils;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<ApiResponseDto<?>> signUpUser(@Valid SignUpRequestDto signUpRequestDto)
            throws UserAlreadyExistsException, RoleNotFoundException {
        if (userService.existsByEmail(signUpRequestDto.getEmail())) {
            throw new UserAlreadyExistsException("Registration Failed: Provided email already exists. Try sign in or provide another email.");
        }
        if (userService.existsByUsername(signUpRequestDto.getUserName())) {
            throw new UserAlreadyExistsException("Registration Failed: Provided username already exists. Try sign in or provide another username.");
        }

        User user = createUser(signUpRequestDto);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponseDto.builder()
                        .isSuccess(true)
                        .message("User account has been successfully created!")
                        .build()
        );
    }

    private User createUser(SignUpRequestDto signUpRequestDto) throws RoleNotFoundException {
        String encryptedPass = passwordEncoder.encode(signUpRequestDto.getPassword());
        return User.builder()
                .email(signUpRequestDto.getEmail())
                .username(signUpRequestDto.getUserName())
                .password(encryptedPass)
                .enabled(true)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> signInUser(@Valid SignInRequestDto signInRequestDto)
            throws SignInException {
        if(signInRequestDto.getEmail().isEmpty()) {
            throw new SignInException("Login Failed: Email field should not be empty.");
        }
        if(signInRequestDto.getPassword().isEmpty()) {
            throw new SignInException("Login Failed: Password field should not be empty.");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDto.getEmail(),
                        signInRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        if(jwt.isEmpty()) {
            throw new SignInException("Login Failed: generateJwtToken failed to generate jwt.");
        }

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        SignInResponseDto signInResponseDto = SignInResponseDto.builder()
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .id(userDetails.getId())
                .token(jwt)
                .type("Bearer")
                .build();

        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .isSuccess(true)
                        .message("Sign in successfull!")
                        .response(signInResponseDto)
                        .build()
        );
    }
}
