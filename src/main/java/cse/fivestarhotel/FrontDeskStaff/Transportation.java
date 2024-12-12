package cse.fivestarhotel.FrontDeskStaff;

import java.io.Serializable;
import java.time.LocalDate;

public class Transportation implements Serializable {
    private String name,email,destination;
    private LocalDate date;
    private String time;
    private String vehicletype;


    public Transportation(String name, String email, String destination, LocalDate date, String time, String vehicletype) {
        this.name = name;
        this.email = email;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.vehicletype = vehicletype;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", vehicletype='" + vehicletype + '\'' +
                '}';
    }





}
