package com.eylul.photoapi.controller;

import com.eylul.photoapi.dto.AlbumRequest;
import com.eylul.photoapi.dto.AlbumResponse;
import com.eylul.photoapi.service.AlbumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    // 1) POST  → createAlbum  (@Valid @RequestBody AlbumRequest), 201 dön
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumResponse create(@Valid @RequestBody AlbumRequest request) {
        return albumService.createAlbum(request);
    }

    // 2) GET   → findAllAlbums
    @GetMapping
    public List<AlbumResponse> findAll() {
        return albumService.findAllAlbums();
    }

    // 3) GET /{id} → findById  (@PathVariable Long id)
    @GetMapping("/{id}")
    public AlbumResponse findById(@PathVariable Long id) {
        return albumService.findById(id);
    }
}
