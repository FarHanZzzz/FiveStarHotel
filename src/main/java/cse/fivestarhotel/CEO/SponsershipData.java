package cse.fivestarhotel.CEO;

import java.io.Serializable;

public class SponsershipData implements Serializable {
    private String name;
    private String status;
    private String type;
    private String expectedRevenue;
    private String generatedRevenue;

    public SponsershipData(String name, String status, String type, String expectedRevenue, String generatedRevenue) {
        this.name = name;
        this.status = status;
        this.type = type;
        this.expectedRevenue = expectedRevenue;
        this.generatedRevenue = generatedRevenue;
    }

    // Getters
    public String getName() {
        return name; }
    public String getStatus() {
        return status; }
    public String getType() {
        return type; }
    public String getExpectedRevenue() {
        return expectedRevenue; }
    public String getGeneratedRevenue() {
        return generatedRevenue; }

    // Setters
    public void setName(String name) {
        this.name = name; }
    public void setStatus(String status) {
        this.status = status; }
    public void setType(String type) {
        this.type = type; }
    public void setExpectedRevenue(String expectedRevenue) {
        this.expectedRevenue = expectedRevenue; }
    public void setGeneratedRevenue(String generatedRevenue) {
        this.generatedRevenue = generatedRevenue; }
}
