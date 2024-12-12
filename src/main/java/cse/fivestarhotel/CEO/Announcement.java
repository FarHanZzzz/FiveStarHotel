package cse.fivestarhotel.CEO;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    private  String  Announcement;
    private LocalDate date;

    public Announcement(String announcement, LocalDate date) {
        Announcement = announcement;
        this.date = date;
    }

    public String getAnnouncement() {
        return Announcement;
    }

    public void setAnnouncement(String announcement) {
        Announcement = announcement;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "Announcement='" + Announcement + '\'' +
                ", date=" + date +
                '}';
    }
}
