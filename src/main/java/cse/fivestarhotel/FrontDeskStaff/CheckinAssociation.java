package cse.fivestarhotel.FrontDeskStaff;

import java.time.LocalDate;

public class CheckinAssociation {
    private String name,email;
    private String roomtype;
    private Integer NoofRooms;
    private Integer roomnumber;
    private LocalDate checkoutDate;

    public CheckinAssociation(String name, String email, String roomtype, Integer noofRooms, Integer roomnumber, LocalDate checkoutDate) {
        this.name = name;
        this.email = email;
        this.roomtype = roomtype;
        NoofRooms = noofRooms;
        this.roomnumber = roomnumber;
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

    public Integer getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(Integer roomnumber) {
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
        return "CheckinAssociation{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", NoofRooms=" + NoofRooms +
                ", roomnumber=" + roomnumber +
                ", checkoutDate=" + checkoutDate +
                '}';
    }
}
