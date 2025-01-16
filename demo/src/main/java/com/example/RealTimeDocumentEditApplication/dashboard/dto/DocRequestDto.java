package com.example.RealTimeDocumentEditApplication.dashboard.dto;

import com.example.RealTimeDocumentEditApplication.dashboard.util.docPermission;

import java.time.Instant;
import java.util.UUID;

public class DocRequestDto {
    private UUID id;
    private String title;
    private String content;
    private Instant createdAt;
    private Instant updated_at;
    private docPermission permissions;
    private String lastUpdatedBy;
    private String owner;

    public DocRequestDto(UUID id, String title, String content, Instant createdAt, Instant updated_at,
                         Integer version, docPermission permissions, String lastUpdatedBy, String owner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updated_at = updated_at;
        this.version = version;
        this.permissions = permissions;
        this.lastUpdatedBy = lastUpdatedBy;
        this.owner = owner;
    }

    private Integer version;

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

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
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
