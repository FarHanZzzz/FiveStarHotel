package cse.fivestarhotel.HotelGuest;

import java.io.Serializable;

public class serRequests implements Serializable {
    private String specifyreq  , name, roomNo, detailnote;

    public serRequests(String specifyreq, String name, String roomNo, String detailnote) {
        this.specifyreq = specifyreq;
        this.name = name;
        this.roomNo = roomNo;
        this.detailnote = detailnote;
    }

    public String getSpecifyreq() {
        return specifyreq;
    }

    public void setSpecifyreq(String specifyreq) {
        this.specifyreq = specifyreq;
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

    public String getDetailnote() {
        return detailnote;
    }

    public void setDetailnote(String detailnote) {
        this.detailnote = detailnote;
    }

    @Override
    public String toString() {
        return "serRequests{" +
                "specifyreq='" + specifyreq + '\'' +
                ", name='" + name + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", detailnote='" + detailnote + '\'' +
                '}';
    }
}
