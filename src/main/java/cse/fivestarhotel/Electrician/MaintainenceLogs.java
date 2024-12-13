package cse.fivestarhotel.Electrician;

import java.time.LocalDate;

public class MaintainenceLogs implements java.io.Serializable {
    private LocalDate date;
    private String status;
    private String task;
    private String observations;

    public MaintainenceLogs() {
    }

    public MaintainenceLogs(LocalDate date, String status, String task, String observations) {
        this.date = date;
        this.status = status;
        this.task = task;
        this.observations = observations;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "MaintainenceLogs{" +
                "date=" + date +
                ", status='" + status + '\'' +
                ", task='" + task + '\'' +
                ", observations='" + observations + '\'' +
                '}';
    }
}

