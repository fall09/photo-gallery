package com.eylul.photoapi.service;

import com.eylul.photoapi.dto.PhotoRequest;
import com.eylul.photoapi.dto.PhotoResponse;
import com.eylul.photoapi.entity.Album;
import com.eylul.photoapi.entity.Photo;
import com.eylul.photoapi.exception.AlbumNotFoundException;
import com.eylul.photoapi.exception.PhotoNotFoundException;
import com.eylul.photoapi.repository.AlbumRepository;
import com.eylul.photoapi.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final AlbumRepository albumRepository;

    @Transactional
    public PhotoResponse addPhoto(Long albumId, PhotoRequest photoRequest) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException(albumId));
        Photo newPhoto = new Photo(album, photoRequest.fileName(), photoRequest.contentType(), photoRequest.sizeBytes());
        Photo savedPhoto = photoRepository.save(newPhoto);
        return PhotoResponse.from(savedPhoto);
    }

    @Transactional(readOnly = true)
    public List<PhotoResponse> findAllByAlbum(Long albumId) {
        if (!albumRepository.existsById(albumId)) {
            throw new AlbumNotFoundException(albumId);
        }
        return photoRepository.findByAlbumId(albumId).stream().map(PhotoResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public PhotoResponse findById(Long albumId, Long photoId) {
        Photo photo = photoRepository.findByAlbumIdAndId(albumId, photoId)
                .orElseThrow(() -> new PhotoNotFoundException(photoId));
        return PhotoResponse.from(photo);
    }
}
