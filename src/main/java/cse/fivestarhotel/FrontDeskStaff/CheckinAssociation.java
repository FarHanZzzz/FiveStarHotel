package cse.fivestarhotel.FrontDeskStaff;

public class CheckinAssociation {
    private String name,email;
    private String roomtype;
    private Integer NoofRooms;

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

    public CheckinAssociation(String name, String email, String roomtype, Integer noofRooms) {
        this.name = name;
        this.email = email;
        this.roomtype = roomtype;
        NoofRooms = noofRooms;
    }


    @Override
    public String toString() {
        return "CheckinAssociation{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", NoofRooms=" + NoofRooms +
                '}';
    }


}
