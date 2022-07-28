package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideReviewRepo  extends JpaRepository<Review,Long> {
   List<Review> findByTourguideId(Long tourguideId);

}
