package cse.fivestarhotel.FrontDeskStaff;

import javafx.scene.control.ComboBox;

public class Guest {
    private String name;
    private String Email;   // Unique Id
    private String MaritalStatus;
    private String Nationality;
    private Integer ContactInfo;

    public Guest(String name, String email, String maritalStatus, String nationality, Integer contactInfo) {
        this.name = name;
        Email = email;
        MaritalStatus = maritalStatus;
        Nationality = nationality;
        ContactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public Integer getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(Integer contactInfo) {
        ContactInfo = contactInfo;
    }
}
