package cse.fivestarhotel.FrontDeskStaff;

import java.time.LocalDate;

public class Book {
    private String name,email;
    private LocalDate Date;
    private String timing;
    private String additionalNotes;


    public Book(String name, String email, LocalDate date, String timing, String additionalNotes) {
        this.name = name;
        this.email = email;
        Date = date;
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

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
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
        return "Book{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Date=" + Date +
                ", timing='" + timing + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }



}
