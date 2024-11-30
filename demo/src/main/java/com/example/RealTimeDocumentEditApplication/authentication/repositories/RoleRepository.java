package com.example.RealTimeDocumentEditApplication.authentication.repositories;

import com.example.RealTimeDocumentEditApplication.authentication.models.ERole;
import com.example.RealTimeDocumentEditApplication.authentication.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
