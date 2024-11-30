package com.example.RealTimeDocumentEditApplication.authentication.repositories;

import com.example.RealTimeDocumentEditApplication.authentication.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Query("SELECT u.password FROM User u WHERE u.username = :username")
    String findPasswordByUsername(@Param("username") String username);
}
