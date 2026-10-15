package com.eylul.photoapi.exception;

public class PhotoNotFoundException extends RuntimeException {
    public PhotoNotFoundException(Long id) {
        super("Photo not found: " + id);
    }
}