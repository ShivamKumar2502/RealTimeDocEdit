package com.example.RealTimeDocumentEditApplication.authentication.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SignInResponseDto {

    private String username;
    private String email;
    private long id;
    private String token;
    private String type;
    private List<String> roles;

//    public SignInResponseDto(String username, String email, long id, String token, String type, List<String> roles) {
//        this.username = username;
//        this.email = email;
//        this.id = id;
//        this.token = token;
//        this.type = type;
//        this.roles = roles;
//    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<String> roles) {
//        this.roles = roles;
//    }

}
