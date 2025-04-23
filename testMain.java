package oop_assigment;

import java.time.LocalDateTime;
import java.util.HashMap;

import oop_assigment.appointment_scheduling.Appointment;
import oop_assigment.appointment_scheduling.AppointmentManager;
import oop_assigment.doctor_patient_interaction.Feedback;
import oop_assigment.doctor_patient_interaction.MedicalHistory;
import oop_assigment.doctor_patient_interaction.Prescription;
import oop_assigment.health_data_handling.VitalSign;
import oop_assigment.health_data_handling.VitalsDatabase;
import oop_assigment.usermanagement.Administrator;
import oop_assigment.usermanagement.Doctor;
import oop_assigment.usermanagement.Patient;

public class testMain{
        public static void main(String[] args) {
                // Doctor
                Doctor doctor = new Doctor(
                        "U001", "D001", "Dr. Alice", "alice@hospital.com", "securePass",
                        "03123456789", "Karachi", 1980, 5, 20, "Cardiology",
                        "City Hospital", "Heart Dept", "15 years"
                );
                // Patient
                Patient patient = new Patient(
                        "U002", "P001", "Bob Khan", "bob@gmail.com", "bob1234", "03456789012", "Lahore", 1995, 3, 10, "B+",
                        "70kg", "5.9ft", "Pollen", "03112223333", "ABC Insurance", 5000.0
                );
                // Administrator
                Administrator admin = new Administrator(
                        "U003", "A001", "Sarah Admin", "admin@hospital.com", "adminpass",
                        "03001112222", "Islamabad", 1985, 7, 25, "Admin Dept", "City Hospital"
                );
                // Vitals
                VitalSign vitals = new VitalSign(
                        "P001", "120/80", 72, 18, 98.6, 97.5, 90.0
                );
                VitalsDatabase vitalsDB = VitalsDatabase.getInstance();
                vitalsDB.addVitalSign("P001", vitals);
                // Prescription
                HashMap<String, String> meds = new HashMap<>();
                meds.put("Paracetamol", "2 times a day");
                meds.put("Antibiotic", "Once a day");
                Prescription prescription = new Prescription("PR001", meds, "5 days", "Take after meals");
                // Feedback
                Feedback feedback = new Feedback("FB001", "Good improvement seen.");
                feedback.addPrescription(prescription);
                // Medical History
                MedicalHistory history = new MedicalHistory("P001");
                history.addFeedback(feedback);
                // Appointment
                Appointment appointment = new Appointment(
                        "AP001", "P001", "D001", LocalDateTime.of(2025, 4, 10, 14, 0),
                        "Routine Checkup", "Scheduled", 1500.0, 30
                );
                appointment.setDoctorAvailability(true);  // Add this if required by logic
                AppointmentManager apptManager = AppointmentManager.getInstance();
                apptManager.addAppointment(appointment);
                // 💡 NEW: Schedule another appointment
                Appointment appointment2 = new Appointment(
                        "AP002", "P001", "D001", LocalDateTime.of(2025, 4, 15, 11, 30),
                        "Follow-up", "Scheduled", 1000.0, 20
                );
                appointment2.setDoctorAvailability(true);
                apptManager.addAppointment(appointment2);
                // Check all appointments
                System.out.println("\n--- All Appointments ---");
                apptManager.checkAllAppointments();
                // Check appointments for doctor
                System.out.println("\n--- Appointments for Doctor D001 ---");
                apptManager.checkDoctorAppointments("D001");
                // Check appointments for a patient
                System.out.println("\n--- Appointments for Patient P001 ---");
                apptManager.checkAppointments("P001");
                // View Medical History Feedbacks
                System.out.println("\n--- Feedback for Patient P001 ---");
                for (Feedback fb : history.getFeedbackList(patient.getPatient_id())) {
                        System.out.println("Feedback ID: " +patient.getPatient_id() );
                        System.out.println("Comment: ");fb.getFeedbackDetails();
                }
                // View Vital Signs
                System.out.println("\n--- Vital Signs for Patient P001 ---");
                vitalsDB.getPatientRecords("P001");
                // Remove an appointment
                System.out.println("\n--- Removing Appointment AP002 ---");
                apptManager.removeAppointment("P001", "AP002");
                // Confirm it's removed
                System.out.println("\n--- Appointments After Removal ---");
                apptManager.checkAppointments("P001");
                System.out.println("\n--- Demo Execution Completed Successfully ---");
        }
}
