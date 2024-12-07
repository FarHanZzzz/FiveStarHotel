package cse.fivestarhotel.FrontDeskStaff;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckInTableDummyClass implements Serializable {
    private String name,email;
    private String roomtype;
    private Integer NoofRooms;
    private String roomnumber;
    private LocalDate checkoutDate;

    public CheckInTableDummyClass(String name, String email, String roomtype, Integer noofRooms, String roomnumber, LocalDate checkoutDate) {
        this.name = name;
        this.email = email;
        this.roomtype = roomtype;
        NoofRooms = noofRooms;
        this.roomnumber = String.valueOf(roomnumber);
        this.checkoutDate = checkoutDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public Integer getNoofRooms() {
        return NoofRooms;
    }

    public void setNoofRooms(Integer noofRooms) {
        NoofRooms = noofRooms;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(Integer roomnumber) {
        this.roomnumber = String.valueOf(roomnumber);
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public String toString() {
        return "CheckInTableDummyClass{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", NoofRooms=" + NoofRooms +
                ", roomnumber=" + roomnumber +
                ", checkoutDate=" + checkoutDate +
                '}';
    }



}
