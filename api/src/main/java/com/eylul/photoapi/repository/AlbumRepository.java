package com.eylul.photoapi.repository;

import com.eylul.photoapi.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository <Album, Long>{


}
