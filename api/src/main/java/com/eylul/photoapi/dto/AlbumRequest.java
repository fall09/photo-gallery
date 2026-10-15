package com.eylul.photoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlbumRequest(
        @NotBlank @Size(max = 100) String name,
        @Size(max = 500) String description
) {
}
