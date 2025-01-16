package com.example.RealTimeDocumentEditApplication.dashboard.models;

import com.example.RealTimeDocumentEditApplication.dashboard.util.docPermission;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "real_time_doc")
public class RealTimeDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "version")
    private Integer version;

    @Column(name = "permissions")
    private docPermission permissions;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "owner")
    private String owner;

    // Constructors
    public RealTimeDoc() {
        // Default constructor required by JPA
    }

    public RealTimeDoc(String title, String content, docPermission permissions, String lastUpdatedBy, String owner) {
        this.title = title;
        this.content = content;
        this.permissions = permissions;
        this.lastUpdatedBy = lastUpdatedBy;
        this.owner = owner;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.version = 1;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public docPermission getPermissions() {
        return permissions;
    }

    public void setPermissions(docPermission permissions) {
        this.permissions = permissions;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}