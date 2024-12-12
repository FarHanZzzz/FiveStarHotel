package cse.fivestarhotel.FrontDeskStaff;

import java.io.Serializable;

public class Query implements Serializable {
    private String name, position , description;

    public Query(String name, String position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {

        return "name='" + name +  ", position='" + position +  ", description='" + description  ;
    }


}
