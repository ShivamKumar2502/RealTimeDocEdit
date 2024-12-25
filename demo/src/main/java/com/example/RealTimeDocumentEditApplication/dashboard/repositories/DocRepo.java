package com.example.RealTimeDocumentEditApplication.dashboard.repositories;

import com.example.RealTimeDocumentEditApplication.dashboard.models.RealTimeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocRepo extends JpaRepository<RealTimeDoc, UUID> {

}

