package ru.miit.spring.TourFirmApp.models;


import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String state;

    private int personId;

    private int roomId;

    private String payState;

    public Item(int id, String state, int personId, int roomId,String payState) {
        this.id = id;
        this.state = state;
        this.personId = personId;
        this.roomId = roomId;
        this.payState = payState;
    }

    public Item() {

    }

    public Item(int personId, int roomId) {
        this.id = getRandomImg();
        this.state ="В обработке" ;
        this.personId = personId;
        this.roomId = roomId;
        this.payState = "Не оплачен";
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getRoomId() {
        return roomId;
    }
    public static int getRandomImg(){
        int x = 1001;
        return (int) (Math.random() * ++x);
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
