package com.example.RealTimeDocumentEditApplication.dashboard.dto;

import java.time.Instant;
import java.util.UUID;

public class DocRequestDto {
    private UUID id;
    private String title;
    private String content;
    private Instant createdAt;
    private Instant updated_at;

    public DocRequestDto(UUID id, String title, String content, Instant createdAt, Instant updated_at,
                         Integer version, String permissions, UUID lastUpdatedBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updated_at = updated_at;
        this.version = version;
        this.permissions = permissions;
        this.lastUpdatedBy = lastUpdatedBy;
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

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public UUID getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UUID lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    private String permissions;
    private UUID lastUpdatedBy;
}
