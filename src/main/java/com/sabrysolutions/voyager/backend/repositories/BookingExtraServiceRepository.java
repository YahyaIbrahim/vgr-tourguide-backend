package com.sabrysolutions.voyager.backend.repositories;



import com.sabrysolutions.voyager.backend.models.BookingExtraService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingExtraServiceRepository extends JpaRepository<BookingExtraService,Long> {

}
