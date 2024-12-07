package cse.fivestarhotel.FrontDeskStaff;

import java.io.Serializable;

public class AcessGuestDetails implements Serializable {
    private String name,email,maritalstatus,nationality;
    private Integer contactno;
    private String roomtype;
    private Integer noofRooms;

    public AcessGuestDetails(String name, String email, String maritalstatus, String nationality, Integer contactno, String roomtype, Integer noofRooms) {
        this.name = name;
        this.email = email;
        this.maritalstatus = maritalstatus;
        this.nationality = nationality;
        this.contactno = contactno;
        this.roomtype = roomtype;
        this.noofRooms = noofRooms;
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

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getContactno() {
        return contactno;
    }

    public void setContactno(Integer contactno) {
        this.contactno = contactno;
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

    @Override
    public String toString() {
        return "AcessGuestDetails{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", maritalstatus='" + maritalstatus + '\'' +
                ", nationality='" + nationality + '\'' +
                ", contactno=" + contactno +
                ", roomtype='" + roomtype + '\'' +
                ", noofRooms=" + noofRooms +
                '}';
    }



}
