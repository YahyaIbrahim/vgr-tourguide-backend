package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface SearchRepository extends JpaRepository<Profile, Id> {
}
