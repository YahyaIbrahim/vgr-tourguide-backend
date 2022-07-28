package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByProfileId(Long touristId);
}
