package cse.fivestarhotel.RestaurantManager;

import java.io.Serializable;

public class Menu implements Serializable {
    private  String dishname , dishtype, mealtype;
    private  Integer price;

    public Menu(String dishname, String dishtype, String mealtype, Integer price) {
        this.dishname = dishname;
        this.dishtype = dishtype;
        this.mealtype = mealtype;
        this.price = price;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDishtype() {
        return dishtype;
    }

    public void setDishtype(String dishtype) {
        this.dishtype = dishtype;
    }

    public String getMealtype() {
        return mealtype;
    }

    public void setMealtype(String mealtype) {
        this.mealtype = mealtype;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "dishname='" + dishname + '\'' +
                ", dishtype='" + dishtype + '\'' +
                ", mealtype='" + mealtype + '\'' +
                ", price=" + price +
                '}';
    }



}
