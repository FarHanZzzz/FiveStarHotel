package cse.fivestarhotel.RestaurantManager;

import java.io.Serializable;

public class PerformanceReport implements Serializable {
    private String customerSatisfaction, month;
    private int totalSpent, EmployeeAttendenceRate;

    public PerformanceReport(String customerSatisfaction, String month, int totalSpent, int employeeAttendenceRate) {
        this.customerSatisfaction = customerSatisfaction;
        this.month = month;
        this.totalSpent = totalSpent;
        EmployeeAttendenceRate = employeeAttendenceRate;
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

    @Override
    public String toString() {
        return "PerformanceReport{" +
                "customerSatisfaction='" + customerSatisfaction + '\'' +
                ", month='" + month + '\'' +
                ", totalSpent=" + totalSpent +
                ", EmployeeAttendenceRate=" + EmployeeAttendenceRate +
                '}';
    }
}