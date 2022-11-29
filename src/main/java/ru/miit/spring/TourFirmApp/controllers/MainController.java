package ru.miit.spring.TourFirmApp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.miit.spring.TourFirmApp.models.Hotel;
import ru.miit.spring.TourFirmApp.models.Item;
import ru.miit.spring.TourFirmApp.models.Room;
import ru.miit.spring.TourFirmApp.repositories.HotelRepository;
import ru.miit.spring.TourFirmApp.repositories.ItemRepository;
import ru.miit.spring.TourFirmApp.repositories.RoomRepository;
import ru.miit.spring.TourFirmApp.security.PersonDetails;
import ru.miit.spring.TourFirmApp.services.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class MainController {
    private final AdminService adminService;
    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;
    private ItemRepository itemRepository;

    @Autowired
    public MainController(AdminService adminService, RoomRepository roomRepository, HotelRepository hotelRepository, ItemRepository itemRepository) {
        this.adminService = adminService;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }

    @GetMapping("/rooms")
    public String testPage(Model model) {

        Iterable<Room> rooms = roomRepository.findAll();
        Iterable<Hotel> hotels = hotelRepository.findAll();
        model.addAttribute("rooms",rooms);
        model.addAttribute("hotels",hotels);
        return "rooms";
    }

    @PostMapping("/rooms/{code}/bron")
    public String bronRoom(@PathVariable int code,Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Item item = new Item(personDetails.getPerson().getId(),code);
        itemRepository.save(item);


        return "redirect:/myOrders";
    }

    @GetMapping("/myOrders")
    public String myOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Iterable<Item> items = itemRepository.findAll();
        List<Item> itemsList = new ArrayList<>();


//        for(Item x:items){
//            if(x.getRoomId() == personDetails.getPerson().getId()){
//                itemsList.add(x);
//                System.out.println(x.getPersonId());
//            }
//        }

        model.addAttribute("items",items);

        return "myOrders";
    }


    @GetMapping("/manager/Reply")
    public String manager(Model model) {

        Iterable<Item> items = itemRepository.findAll();


        model.addAttribute("items",items);
        return "manager";
    }


    @PutMapping("/manager/{code}/confirm")
    public String managerConfirm(@PathVariable int code,Model model) {


        Item order = itemRepository.findById(code).orElseThrow();
        order.setId(code);
        order.setState("Подтверждён");

        itemRepository.save(order);


        return "redirect:/manager/Reply";
    }

    @PutMapping("/manager/{code}/disable")
    public String managerDisable(@PathVariable int code,Model model) {


        Item order = itemRepository.findById(code).orElseThrow();
        order.setId(code);
        order.setState("Отказано");

        itemRepository.save(order);


        return "redirect:/manager/Reply";
    }


    @GetMapping("/order/{code}/pay")
    public String pay(@PathVariable int code,Model model) {


        Item order = itemRepository.findById(code).orElseThrow();
        model.addAttribute("item",order);

        return "pay";
    }

    @PutMapping("/order/{code}/pay")
    public String payPut(@PathVariable int code,Model model) {

        Item order = itemRepository.findById(code).orElseThrow();

        order.setPayState("Оплачен");

        itemRepository.save(order);

        return "redirect:/myOrders";
    }
}
