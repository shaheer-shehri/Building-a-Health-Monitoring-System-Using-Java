package email_service.usermanagement;
import java.util.ArrayList;
import java.util.List;

import email_service.appointment_scheduling.Appointment;
import email_service.doctor_patient_interaction.Prescription;
import email_service.health_data_handling.VitalSign;
import email_service.health_data_handling.VitalsDatabase;

public class Patient extends User {
    private String patient_id;
    private String blood_group;
    private String weight;
    private String height;
    private String allergies;
    private String emergency_contact;
    private String insuranceInfo;
    private double remaining_dues;
    // Constructor for Patient class
    public Patient(String user_id,String patient_id, String name, String email_address, String password, String phone_no,
        String address, int year_of_birth, int month_of_birth, int day_of_birth, String blood_group,
        String weight, String height, String allergies, String emergency_contact, String insuranceInfo, double remaining_dues) {
        super(user_id,name, email_address, password, phone_no, address, year_of_birth, month_of_birth, day_of_birth);
        this.patient_id = patient_id;
        this.blood_group = blood_group;
        this.weight = weight;
        this.height = height;
        this.allergies = allergies;
        this.emergency_contact = emergency_contact;
        this.insuranceInfo = insuranceInfo;
        this.remaining_dues = remaining_dues;
    }
    // over riding the displayUser method from the User class
    @Override
    public void displayUser(){
        System.out.println("Patient ID: " + this.patient_id);
        System.out.println("Name: " + this.getName());
        System.out.println("Email Address: " + this.getEmail_address());
        System.out.println("Phone Number: " + this.getPhone_no());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Date of Birth: " + this.getDate_of_birth().toString());
        System.out.println("Blood Group: " + this.blood_group);
        System.out.println("Weight: " + this.weight);
        System.out.println("Height: " + this.height);
        System.out.println("Allergies: " + this.allergies);
        System.out.println("Emergency Contact: " + this.emergency_contact);
        System.out.println("Insurance Info: " + this.insuranceInfo);
    }
    // Getters and Setters for Patient class attributes
    public void setRemaining_dues(double remaining_dues) {
        this.remaining_dues = remaining_dues;
    }
    public Double getRemaining_dues() {
        return this.remaining_dues;
    }
    public String getPatient_id() {
        return this.patient_id;
    }
    public String getBlood_group() {
        return this.blood_group;
    }
    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
    public String getWeight() {
        return this.weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getHeight() {
        return this.height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getAllergies() {
        return this.allergies;
    }
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    public String getEmergency_contact() {
        return this.emergency_contact;
    }
    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
    public String getInsuranceInfo() {
        return this.insuranceInfo;
    }
    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }
    // creating the attributes related to the medical history and appointments , vital signs
    private ArrayList<Prescription> medications = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<VitalSign> vitalHistory = new ArrayList<>();
    public void addPrescription(Prescription prescription) {
        this.medications.add(prescription);
    }
    public void removePrescription(Prescription prescription) {
        this.medications.remove(prescription);
    }
    public String getMedicationDetails(){
        StringBuilder details = new StringBuilder("Medications for " + this.getName() + ":\n");
        for (Prescription prescription : medications) {
            details.append(prescription.toString()).append("\n");
        }
        return details.toString();
    }
    // creating the methods to set and get the values of these attributes
    public void uploadVitals(VitalSign vitals) {
        vitalHistory.add(vitals);
        VitalsDatabase.getInstance().addVitalSign(this, vitals);
    }
    public List<VitalSign> getVitalHistory() {
        return vitalHistory;
    }
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    @Override
    public String toString() {
        return "Patient{" +
                "patient_id='" + patient_id + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", allergies='" + allergies + '\'' +
                ", emergency_contact='" + emergency_contact + '\'' +
                ", email_address='" + this.getEmail_address() + '\'' +
                ", remaining_dues=" + remaining_dues +
                '}';
    }
    public String getAppointmentsDetail(){
        StringBuilder details = new StringBuilder("Appointments for " + this.getName() + ":\n");
        for (Appointment appointment : appointments) {
            details.append(appointment.toString()).append("\n");
        }
        return details.toString();
    }
    
}
