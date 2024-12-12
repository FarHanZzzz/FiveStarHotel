package cse.fivestarhotel.HotelGuest;

import java.io.Serializable;

public class Laundry implements Serializable {
    private String name, roomNo, addiNotes;

    public Laundry(String name, String roomNo, String addiNotes) {
        this.name = name;
        this.roomNo = roomNo;
        this.addiNotes = addiNotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getAddiNotes() {
        return addiNotes;
    }

    public void setAddiNotes(String addiNotes) {
        this.addiNotes = addiNotes;
    }

    @Override
    public String toString() {
        return "Laundry{" +
                "name='" + name + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", addiNotes='" + addiNotes + '\'' +
                '}';
    }
}