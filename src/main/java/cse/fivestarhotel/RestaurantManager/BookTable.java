package cse.fivestarhotel.RestaurantManager;

import java.io.Serializable;
import java.time.LocalDate;

public class BookTable implements Serializable {

    private String name,time;
    private LocalDate date;
    private String noofPeople;

    public BookTable(String name, String time, LocalDate date, String noofPeople) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.noofPeople = noofPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNoofPeople() {
        return noofPeople;
    }

    public void setNoofPeople(String noofPeople) {
        this.noofPeople = noofPeople;
    }

    @Override
    public String toString() {
        return "BookTable{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", date=" + date +
                ", noofPeople='" + noofPeople + '\'' +
                '}';
    }
}
