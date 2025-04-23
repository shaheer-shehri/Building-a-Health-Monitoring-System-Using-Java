package email_service.usermanagement;
import java.util.ArrayList;
import java.util.List;

import email_service.appointment_scheduling.Appointment;
import email_service.doctor_patient_interaction.Feedback;
import email_service.doctor_patient_interaction.MedicalHistory;

public class Doctor extends User {
    private String doctor_id;
    private String specialization;
    private String hospital;
    private String department;
    private String experience;
    private int appointments_today = 0;
    private List<Patient> assignedPatients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    // Constructor to initialize the doctor object
    public Doctor(String user_id, String doctor_id, String name, String email_address, String password, String phone_no,
        String address, int year_of_birth, int month_of_birth, int day_of_birth, String specialization,
        String hospital, String department, String experience) {
        super(user_id, name, email_address, password, phone_no, address, year_of_birth, month_of_birth, day_of_birth);
        this.doctor_id = doctor_id;
        this.specialization = specialization;
        this.hospital = hospital;
        this.department = department;
        this.experience = experience;
    }
    // over riding the method to display the user information
    public void displayUser(){
        System.out.println("Doctor ID: " + this.doctor_id);
        System.out.println("Name: " + this.getName());
        System.out.println("Email Address: " + this.getEmail_address());
        System.out.println("Phone Number: " + this.getPhone_no());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Date of Birth: " + this.getDate_of_birth().toString());
        System.out.println("Specialization: " + this.specialization);
        System.out.println("Hospital: " + this.hospital);
        System.out.println("Department: " + this.department);
        System.out.println("Experience: " + this.experience);
    }
    // Getters and Setters for each attribute
    public void setDoctorId(String doctor_id){
        this.doctor_id = doctor_id;
    }
    public String getDoctorId(){
        return this.doctor_id;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public String getSpecialization(){
        return this.specialization;
    }
    public void setHospital(String hospital){
        this.hospital = hospital;
    }
    public String getHospital(){
        return this.hospital;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return this.department;
    }
    public void setExperience(String experience){
        this.experience = experience;
    }
    public String getExperience(){
        return this.experience;
    }
    // to set appointments of doctor at a specific limit per day
    public void setAppointmentsToday(){
        if (this.appointments_today < 5){
            this.appointments_today += 1;
        }
        else{
            System.out.println("Doctor is not available");
        }
    }
    public void addPatient(Patient patient) {
        assignedPatients.add(patient);
    }
    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
    }
    // to get the list of patients assigned to the doctor
    public List<Patient> getAssignedPatients() {
        return this.assignedPatients;
    }
    // to save the appointments detail and prescription for the patient in the medical history database
    public void prescribeMedication(Patient patient, Feedback feedback){
        MedicalHistory medicalHistory = new MedicalHistory(patient);
        medicalHistory.addFeedback(feedback);
    }
}
