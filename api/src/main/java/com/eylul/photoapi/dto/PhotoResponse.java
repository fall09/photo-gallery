package com.eylul.photoapi.dto;

import com.eylul.photoapi.entity.Photo;
import com.eylul.photoapi.entity.PhotoStatus;

import java.time.Instant;

public record PhotoResponse(
        Long id,
        Long albumId,
        String fileName,
        String contentType,
        long sizeBytes,
        PhotoStatus status,
        Instant createdAt
) {
    public static PhotoResponse from(Photo photo) {
        return new PhotoResponse(
                photo.getId(),
                photo.getAlbum().getId(),
                photo.getFileName(),
                photo.getContentType(),
                photo.getSizeBytes(),
                photo.getStatus(),
                photo.getCreatedAt()
        );
    }
}
