package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositiory extends JpaRepository<Messages,Long> {
}
