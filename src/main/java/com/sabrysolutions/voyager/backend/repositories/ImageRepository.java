package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {

    List<Image> findByProfileId(Long touristId);
}
