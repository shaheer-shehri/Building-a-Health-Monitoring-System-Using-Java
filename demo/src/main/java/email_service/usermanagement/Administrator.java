package email_service.usermanagement;
import java.util.List;

public class Administrator extends User{
    private String admin_id;
    private String department;
    private String hospital_name;
    private List<Patient> patients;
    private List<Doctor> doctors;
    // Constructor to initialize the administrator object
    public Administrator(String user_id, String admin_id, String name, String email_address, String password, String phone_no,
        String address, int year_of_birth, int month_of_birth, int day_of_birth, String department, String hospital_name) {
        super(user_id, name, email_address, password, phone_no, address, year_of_birth, month_of_birth, day_of_birth);
        this.admin_id = admin_id;
        this.department = department;
        this.hospital_name = hospital_name;
    }
    // Getters and Setters for each attribute
    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    public String getAdmin_id() {
        return this.admin_id;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return this.department;
    }
    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }
    public String getHospital_name() {
        return this.hospital_name;
    }
    // to allow admin to manage doctors and patients and apply discounts on bills of the patients
    public void apply_discount(Patient patient, double discount){
        patient.setRemaining_dues(patient.getRemaining_dues() - discount);
    }
    public void discharge_patient(Patient patient){
        patient.setRemaining_dues(0);
    }
    public void add_doctor( Doctor doctor){
        this.doctors.add(doctor);
    }
    public void remove_doctor(Doctor doctor){
        this.doctors.remove(doctor);
    }
    public void add_patient(Patient patient){
        this.patients.add(patient);
    }
    // method over riding to display the user information
    public void displayUser(){
        System.out.println("Admin ID: " + this.admin_id);
        System.out.println("Name: " + this.getName());
        System.out.println("Email Address: " + this.getEmail_address());
        System.out.println("Phone Number: " + this.getPhone_no());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Date of Birth: " + this.getDate_of_birth().toString());
        System.out.println("Department: " + this.department);
        System.out.println("Hospital Name: " + this.hospital_name);
    }
}