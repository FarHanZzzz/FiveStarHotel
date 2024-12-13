package cse.fivestarhotel.CEO;

import java.time.LocalDate;
import java.io.Serializable;

public class DepartmentBudget implements Serializable {
    private String departmentName;
    private double budget;
    private LocalDate budgetDate;

    public DepartmentBudget(String departmentName) {
        this.departmentName = departmentName;
        this.budget = 0.0 ;
        this.budgetDate = null; // Initialize as null to represent no date set
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(LocalDate budgetDate) {
        this.budgetDate = budgetDate;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public DepartmentBudget(String departmentName, double budget, LocalDate budgetDate) {
        this.departmentName = departmentName;
        this.budget = budget;
        this.budgetDate = budgetDate;
    }
}
