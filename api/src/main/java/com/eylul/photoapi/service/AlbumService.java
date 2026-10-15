package com.eylul.photoapi.service;

import com.eylul.photoapi.dto.AlbumRequest;
import com.eylul.photoapi.dto.AlbumResponse;
import com.eylul.photoapi.entity.Album;
import com.eylul.photoapi.exception.AlbumNotFoundException;
import com.eylul.photoapi.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Transactional
    public AlbumResponse createAlbum(AlbumRequest albumRequest) {
        Album newAlbum = new Album(albumRequest.name(), albumRequest.description());
        Album savedAlbum = albumRepository.save(newAlbum);
        return AlbumResponse.from(savedAlbum);
    }
    @Transactional(readOnly = true)
    public List<AlbumResponse> findAllAlbums() {
        return albumRepository.findAll().stream().map(AlbumResponse::from).toList();
    }
    @Transactional(readOnly = true)
    public AlbumResponse findById(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));
        return AlbumResponse.from(album);
    }
}