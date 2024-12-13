package cse.fivestarhotel.HotelHeadManager;

import java.io.Serializable;

public class Budget implements Serializable {
    private String budget, month;

    public Budget(String budget, String month) {
        this.budget = budget;
        this.month = month;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "budget='" + budget + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}