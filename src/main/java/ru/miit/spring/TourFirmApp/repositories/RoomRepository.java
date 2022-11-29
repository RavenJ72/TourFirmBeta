package ru.miit.spring.TourFirmApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.spring.TourFirmApp.models.Person;
import ru.miit.spring.TourFirmApp.models.Room;

import java.util.Optional;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
