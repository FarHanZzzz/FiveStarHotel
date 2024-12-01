package cse.fivestarhotel.FrontDeskStaff;

import javafx.scene.control.ComboBox;

public class Guest {

    private String name;
    private Integer id;
    private String maritalStatus;
    private String nationality;
    private Integer contactNo;

    public Guest(String name, Integer id, String maritalStatus, String nationality, Integer contactNo) {
        this.name = name;
        this.id = id;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getContactNo() {
        return contactNo;
    }

    public void setContactNo(Integer contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", nationality='" + nationality + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }




}
