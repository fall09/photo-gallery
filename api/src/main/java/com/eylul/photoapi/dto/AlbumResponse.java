package com.eylul.photoapi.dto;

import com.eylul.photoapi.entity.Album;

import java.time.Instant;

public record AlbumResponse(
        Long id,
        String name,
        String description,
        Instant createdAt
) {
    public static AlbumResponse from(Album album) {
        return new AlbumResponse(
                album.getId(),
                album.getName(),
                album.getDescription(),
                album.getCreatedAt()
        );
    }
}
