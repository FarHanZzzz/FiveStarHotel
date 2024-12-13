package cse.fivestarhotel.CEO;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    private String position, Announcement;
    private LocalDate date;

    public Announcement(String position, String announcement, LocalDate date) {
        this.position = position;
        Announcement = announcement;
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
                "position='" + position + '\'' +
                ", Announcement='" + Announcement + '\'' +
                ", date=" + date +
                '}';
    }
}