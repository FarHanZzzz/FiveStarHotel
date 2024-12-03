package cse.fivestarhotel.FrontDeskStaff;

import javafx.scene.control.ComboBox;

public class Room {

    private String roomtype;
    private Integer roomid;
    private Boolean availability;


    public Room(String roomtype, Integer roomid, Boolean availability) {
        this.roomtype = roomtype;
        this.roomid = roomid;
        this.availability = availability;
    }


    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomtype='" + roomtype + '\'' +
                ", roomid=" + roomid +
                ", availability=" + availability +
                '}';
    }


}
