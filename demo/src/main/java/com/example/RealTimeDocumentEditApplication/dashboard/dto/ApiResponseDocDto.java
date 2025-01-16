package com.example.RealTimeDocumentEditApplication.dashboard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ApiResponseDocDto<T> {
    private boolean isSuccess;
    private String message;
    private T response;

    public ApiResponseDocDto(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ApiResponseDocDto(boolean isSuccess, String message, T response) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.response = response;
    }
}
