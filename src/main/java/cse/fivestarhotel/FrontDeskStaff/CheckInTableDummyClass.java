package cse.fivestarhotel.FrontDeskStaff;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckInTableDummyClass  {
    private String name;
    private String email;
    private String roomtype;
    private Integer noofRooms;
    private String roomnumber;
    private LocalDate checkoutDate;

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
        return noofRooms;
    }

    public void setNoofRooms(Integer noofRooms) {
        this.noofRooms = noofRooms;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
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
                ", noofRooms=" + noofRooms +
                ", roomnumber='" + roomnumber + '\'' +
                ", checkoutDate=" + checkoutDate +
                '}';
    }

    public CheckInTableDummyClass(String name, String email, String roomtype, Integer noofRooms, String roomnumber, LocalDate checkoutDate) {
        this.name = name;
        this.email = email;
        this.roomtype = roomtype;
        this.noofRooms = noofRooms;
        this.roomnumber = roomnumber;
        this.checkoutDate = checkoutDate;




    }
}
