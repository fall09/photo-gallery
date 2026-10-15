package com.eylul.photoapi.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Album(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
