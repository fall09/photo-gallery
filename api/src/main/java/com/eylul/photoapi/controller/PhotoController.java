package com.eylul.photoapi.controller;

import com.eylul.photoapi.dto.PhotoRequest;
import com.eylul.photoapi.dto.PhotoResponse;
import com.eylul.photoapi.service.PhotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums/{albumId}/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PhotoResponse addPhoto(@PathVariable Long albumId, @Valid @RequestBody PhotoRequest request) {
        return photoService.addPhoto(albumId, request);
    }

    @GetMapping
    public List<PhotoResponse> findAllByAlbum(@PathVariable Long albumId) {
        return photoService.findAllByAlbum(albumId);
    }

    @GetMapping("/{photoId}")
    public PhotoResponse findById(@PathVariable Long albumId, @PathVariable Long photoId) {
        return photoService.findById(albumId, photoId);
    }
}
