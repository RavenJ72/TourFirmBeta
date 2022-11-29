package ru.miit.spring.TourFirmApp.models;


import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class Hotel {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "starsType")
    private int starsType;

    @Column(name = "rating")
    private int rating;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, int starsType, int rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.starsType = starsType;
        this.rating = rating;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStarsType() {
        return starsType;
    }

    public void setStarsType(int starsType) {
        this.starsType = starsType;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
