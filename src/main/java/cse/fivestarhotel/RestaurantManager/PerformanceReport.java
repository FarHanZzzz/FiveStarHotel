package cse.fivestarhotel.RestaurantManager;

import java.io.Serializable;

public class PerformanceReport implements Serializable {
    private  String name, customerSatisfaction,month;
    private int totalSpent, EmployeeAttendenceRate;
    private String summary;


    public PerformanceReport(String name, String customerSatisfaction, String month, int totalSpent, int employeeAttendenceRate, String summary) {
        this.name = name;
        this.customerSatisfaction = customerSatisfaction;
        this.month = month;
        this.totalSpent = totalSpent;
        EmployeeAttendenceRate = employeeAttendenceRate;
        this.summary = summary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public void setCustomerSatisfaction(String customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }

    public int getEmployeeAttendenceRate() {
        return EmployeeAttendenceRate;
    }

    public void setEmployeeAttendenceRate(int employeeAttendenceRate) {
        EmployeeAttendenceRate = employeeAttendenceRate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "PerformanceReport{" +
                "name='" + name + '\'' +
                ", customerSatisfaction='" + customerSatisfaction + '\'' +
                ", month='" + month + '\'' +
                ", totalSpent=" + totalSpent +
                ", EmployeeAttendenceRate=" + EmployeeAttendenceRate +
                ", summary='" + summary + '\'' +
                '}';
    }
}
