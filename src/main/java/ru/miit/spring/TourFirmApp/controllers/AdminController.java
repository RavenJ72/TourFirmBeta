package ru.miit.spring.TourFirmApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.miit.spring.TourFirmApp.models.Hotel;
import ru.miit.spring.TourFirmApp.models.Person;
import ru.miit.spring.TourFirmApp.models.Room;
import ru.miit.spring.TourFirmApp.repositories.HotelRepository;
import ru.miit.spring.TourFirmApp.repositories.RoomRepository;
import ru.miit.spring.TourFirmApp.services.RegistrationService;
import ru.miit.spring.TourFirmApp.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;

    @Autowired
    public AdminController(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }



    @GetMapping("/Info")
    public String adminHomepage(Model model){
            model.addAttribute("title","Admin Home Page");
            Iterable<Room> rooms = roomRepository.findAll();
            Iterable<Hotel> hotels = hotelRepository.findAll();
            model.addAttribute("rooms",rooms);
            model.addAttribute("hotels",hotels);
            return "admin";


    }

    @GetMapping("/newRoom")
    public String roomAdditionPage(@ModelAttribute("room") Room room) {
        return "newRoom";
    }

    @PostMapping("/newRoom")
    public String roomPostRequest(@ModelAttribute("room") Room room) {
        roomRepository.save(room);
        return "redirect:/admin/Info";
    }

    @DeleteMapping("/rooms/{code}/delete")
    public String delRoom(@PathVariable int code) {
        roomRepository.delete(roomRepository.findById(code).orElseThrow());
        return "redirect:/admin/Info";
    }

    @GetMapping("/newHotel")
    public String hotelAdditionPage(@ModelAttribute("hotel") Hotel hotel) {
        return "newHotel";
    }

    @PostMapping("/newHotel")
    public String hotelPostRequest(@ModelAttribute("hotel") Hotel hotel) {
        hotelRepository.save(hotel);
        return "redirect:/admin/Info";
    }

    @DeleteMapping("/hotels/{code}/delete")
    public String delHotel(@PathVariable int code) {
        hotelRepository.delete(hotelRepository.findById(code).orElseThrow());
        return "redirect:/admin/Info";
    }





}
