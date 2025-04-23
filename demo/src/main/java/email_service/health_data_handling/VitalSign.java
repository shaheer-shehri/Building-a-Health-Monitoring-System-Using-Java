package email_service.health_data_handling;
import java.time.LocalDate;

import email_service.usermanagement.Patient;

public class VitalSign{
    private Patient patient;
    private String bloodPressure;
    private int heartRate;
    private int respiratoryRate;
    private double temperature;
    private double bloodOxygenLevel;
    private double bloodSugarLevel;
    private LocalDate reportDate;
    // Constructor to initialize the vital sign data
    public VitalSign(Patient patient,String bloodPressure, int heartRate, int respiratoryRate, double temperature, double bloodOxygenLevel, double bloodSugarLevel) {
        this.patient = patient;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.temperature = temperature;
        this.bloodOxygenLevel = bloodOxygenLevel;
        this.bloodSugarLevel = bloodSugarLevel;
        this.reportDate = LocalDate.now();
    }
    // Getters and Setters for each vital sign attribute
    public Patient getPatient() {
        return this.patient;
    }
    public String getBloodPressure() {
        return this.bloodPressure;
    }
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    public int getHeartRate() {
        return this.heartRate;
    }
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
    public int getRespiratoryRate() {
        return this.respiratoryRate;
    }
    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }
    public double getTemperature() {
        return this.temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getBloodOxygenLevel() {
        return this.bloodOxygenLevel;
    }
    public void setBloodOxygenLevel(double bloodOxygenLevel) {
        this.bloodOxygenLevel = bloodOxygenLevel;
    }
    public double getBloodSugarLevel() {
        return this.bloodSugarLevel;
    }
    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }
    public LocalDate getReportDate() {
        return this.reportDate;
    }
    // over riding the toString method to display the vital sign data
    public String toString() {
        return "Patient : " + this.patient + "\nBlood Pressure: "
            + this.bloodPressure + "\nHeart Rate: " + this.heartRate +
            "\nRespiratory Rate: " + this.respiratoryRate + "\nTemperature: " +
            this.temperature + "\nBlood Oxygen Level: " + this.bloodOxygenLevel +
            "\nBlood Sugar Level: " + this.bloodSugarLevel + "\nReport Date: "
            + this.reportDate;
    }
}
