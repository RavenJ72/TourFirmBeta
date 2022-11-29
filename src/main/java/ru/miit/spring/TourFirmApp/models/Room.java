package ru.miit.spring.TourFirmApp.models;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "square")
    private int square;

    @Column(name = "price")
    private String price;

    @Column(name = "typeOfFood")
    private String typeOfFood;

    @Column(name = "bedCount")
    private int bedCount;

    @Column(name = "hotelName")
    private String hotelName;

    public Room() {
    }

    public Room(int id, String name, int square, String price, String typeOfFood, int bedCount, String hotelName) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.price = price;
        this.typeOfFood = typeOfFood;
        this.bedCount = bedCount;
        this.hotelName = hotelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public int getRandomImg(){
        int x = 6;
        return (int) (Math.random() * ++x);
    }
}

