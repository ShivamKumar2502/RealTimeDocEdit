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
}