package cse.fivestarhotel.HotelHeadManager;

import java.io.Serializable;

public class Revenue implements Serializable {
    private String revenue, month;

    public Revenue(String revenue, String month) {
        this.revenue = revenue;
        this.month = month;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "revenue='" + revenue + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}