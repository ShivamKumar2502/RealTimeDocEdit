package com.example.RealTimeDocumentEditApplication.dashboard.controller;

import com.example.RealTimeDocumentEditApplication.dashboard.dto.ApiResponseDocDto;
import com.example.RealTimeDocumentEditApplication.dashboard.dto.DocRequestDto;
import com.example.RealTimeDocumentEditApplication.dashboard.services.DocService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DocController {

    @Autowired
    private DocService docService;

    @PostMapping("/document")
    public ResponseEntity<ApiResponseDocDto<?>> saveDocument(@RequestBody @Valid DocRequestDto docRequestDto){
        return docService.createDocument(docRequestDto);
    }

    @PostMapping("/document/{id}")
    public ResponseEntity<ApiResponseDocDto<?>> updateDocument(@PathVariable UUID id, @RequestBody @Valid DocRequestDto docRequestDto){
        return docService.updateDocument(id, docRequestDto);
    }

}
