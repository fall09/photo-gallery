package com.eylul.photoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eylul.photoapi.entity.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo,Long> {
    List<Photo> findByAlbumId(Long albumId);
    Optional<Photo> findByAlbumIdAndId(Long albumId, Long id);
}
