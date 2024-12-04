package cse.fivestarhotel.FrontDeskStaff;

public class CheckinAssociation {
    private String name,email;
    private String roomtype;
    private Integer NoofRooms;
    private String roomid;

    public CheckinAssociation(String name, String email, String roomtype, Integer noofRooms, String roomid) {
        this.name = name;
        this.email = email;
        this.roomtype = roomtype;
        NoofRooms = noofRooms;
        this.roomid = roomid;
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

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    @Override
    public String toString() {
        return "CheckinAssociation{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", NoofRooms=" + NoofRooms +
                ", roomid='" + roomid + '\'' +
                '}';
    }

}
