package com.example.RealTimeDocumentEditApplication.dashboard.services;

import com.example.RealTimeDocumentEditApplication.dashboard.dto.ApiResponseDocDto;
import com.example.RealTimeDocumentEditApplication.dashboard.dto.DocRequestDto;
import com.example.RealTimeDocumentEditApplication.dashboard.models.RealTimeDoc;
import com.example.RealTimeDocumentEditApplication.dashboard.repositories.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocService {

    private final DocRepo documentRepository;

    @Autowired
    public DocService(DocRepo documentRepository) {
        this.documentRepository = documentRepository;
    }

    public ResponseEntity<ApiResponseDocDto<?>> createDocument(DocRequestDto docRequestDto) {
        RealTimeDoc realTimeDoc = createDoc(docRequestDto);
        documentRepository.save(realTimeDoc);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponseDocDto.builder()
                        .isSuccess(true)
                        .message("Document has been successfully created!")
                        .build()
        );
    }

    private RealTimeDoc createDoc(DocRequestDto docRequestDto) {
        return new RealTimeDoc(docRequestDto.getTitle(), docRequestDto.getContent(), docRequestDto.getPermissions(), docRequestDto.getLastUpdatedBy());
    }

    public ResponseEntity<ApiResponseDocDto<?>> updateDocument(UUID id, DocRequestDto docRequestDto) {
        RealTimeDoc updatedDocument = createDoc(docRequestDto);
        RealTimeDoc existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        existingDocument.setTitle(updatedDocument.getTitle());
        existingDocument.setContent(updatedDocument.getContent());
        existingDocument.setPermissions(updatedDocument.getPermissions());
        existingDocument.setLastUpdatedBy(updatedDocument.getLastUpdatedBy());
        existingDocument.setUpdatedAt(updatedDocument.getUpdatedAt());
        existingDocument.setVersion(existingDocument.getVersion() + 1);

        documentRepository.save(existingDocument);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                ApiResponseDocDto.builder()
                        .isSuccess(true)
                        .message("Document updated successfully!")
                        .build()
        );
    }

    public List<RealTimeDoc> getAllDocuments() {
        return documentRepository.findAll();
    }

    public void deleteDocument(UUID id) {
        documentRepository.deleteById(id);
    }
}
