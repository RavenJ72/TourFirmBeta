package ru.miit.spring.TourFirmApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.spring.TourFirmApp.models.Hotel;
import ru.miit.spring.TourFirmApp.models.Person;

import java.util.Optional;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
