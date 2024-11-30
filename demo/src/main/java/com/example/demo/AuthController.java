/*
http://localhost:8080/hello/user will return the string Hello User.
http://localhost:8080/hello/admin will return the string Hello Admin.
 */

package com.example.demo;

import com.example.demo.exception.RoleNotFoundException;
import com.example.demo.exception.UserAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @GetMapping("user")
//    public ResponseEntity<ApiResponseDto<?>> helloUser() {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(new ApiResponseDto<>(true, "Hello User!"));
//    }
//
//    @GetMapping("admin")
//    public ResponseEntity<ApiResponseDto<?>> helloAdmin() {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(new ApiResponseDto<>(true, "Hello Admin!"));
//    }
}
