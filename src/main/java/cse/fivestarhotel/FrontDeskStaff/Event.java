package cse.fivestarhotel.FrontDeskStaff;

import java.time.LocalDate;

public class Event {
    private String name,email;
    private String eventType;
    private LocalDate date;
    private String timing;
    private String additionalNotes;


    public Event(String name, String email, String eventType, LocalDate date, String timing, String additionalNotes) {
        this.name = name;
        this.email = email;
        this.eventType = eventType;
        this.date = date;
        this.timing = timing;
        this.additionalNotes = additionalNotes;

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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", eventType='" + eventType + '\'' +
                ", Date=" + date +
                ", timing='" + timing + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }



}
