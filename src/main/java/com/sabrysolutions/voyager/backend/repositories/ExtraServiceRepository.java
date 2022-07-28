package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.models.ExtraService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraServiceRepository extends JpaRepository<ExtraService,Long> {

   public ExtraService findFirstById(long id);
}
