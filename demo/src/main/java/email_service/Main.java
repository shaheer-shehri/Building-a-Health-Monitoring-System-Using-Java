package email_service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import email_service.appointment_scheduling.Appointment;
import email_service.chat_video_consultation.ChatClient;
import email_service.chat_video_consultation.ChatServer;
import email_service.chat_video_consultation.VideoCall;
import email_service.doctor_patient_interaction.Prescription;
import email_service.emergency_alert_system.EmergencyAlert;
import email_service.emergency_alert_system.Panic_button;
import email_service.health_data_handling.VitalSign;
import email_service.health_data_handling.VitalsDatabase;
import email_service.notification_remainders.EmailNotification;
import email_service.notification_remainders.RemainderService;
import email_service.notification_remainders.SMSNotification;
import email_service.usermanagement.Doctor;
import email_service.usermanagement.Patient;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HEALTHCARE SYSTEM TEST PROGRAM ===\n");
        
        // Test Part 1: User Management
        System.out.println("=== PART 1: USER MANAGEMENT ===");
        
        // Create a doctor
        Doctor doctor = new Doctor("U001", "D001", "Dr. Sarah Johnson", "sarah.johnson@hospital.com", 
                                  "password123", "12345678901", "123 Medical Center", 
                                  1980, 5, 15, "Cardiology", "General Hospital", 
                                  "Cardiac Care", "15 years");
        
        // Explicitly set date of birth for doctor
        doctor.setDate_of_birth(1980, 5, 15);
        
        // Create patients
        Patient patient1 = new Patient("U002", "P001", "John Smith", "shaheermurtaza47@gmail.com",
                                      "password123", "12345678901", "456 Main St", 
                                      1990, 8, 20, "O+", "75 kg", "180 cm", 
                                      "Penicillin", "12345678901", "Insurance123", 0.0);
        
        Patient patient2 = new Patient("U003", "P002", "Emma Davis", "akhan.bsds24seecs@seecs.edu.pk", 
                                      "password123", "12345678901", "789 Oak St", 
                                      1985, 3, 10, "A-", "65 kg", "165 cm", 
                                      "None", "98765432101", "Insurance456", 250.0);
        
        // Explicitly set date of birth for patients
        patient1.setDate_of_birth(1990, 8, 20);
        patient2.setDate_of_birth(1985, 3, 10);
        
        // Display user information
        System.out.println("Doctor Information:");
        doctor.displayUser();
        System.out.println("\nPatient 1 Information:");
        patient1.displayUser();
        System.out.println("\nPatient 2 Information:");
        patient2.displayUser();
        
        // Assign patients to doctor
        doctor.addPatient(patient1);
        doctor.addPatient(patient2);
        
        System.out.println("\nDoctor's Assigned Patients:");
        for (Patient patient : doctor.getAssignedPatients()) {
            System.out.println("- " + patient.getName() + " (ID: " + patient.getPatient_id() + ")");
        }
        
        // Test Part 2: Health Data Handling
        System.out.println("\n=== PART 2: HEALTH DATA HANDLING ===");
        
        // Create vital signs for patients
        VitalSign vitals1 = new VitalSign(patient1, "120/80", 75, 16, 37.0, 98.0, 110.0);
        VitalSign vitals2 = new VitalSign(patient1, "130/85", 82, 18, 37.5, 96.0, 125.0);
        VitalSign vitals3 = new VitalSign(patient2, "115/75", 68, 14, 36.8, 97.5, 105.0);
        VitalSign criticalVitals = new VitalSign(patient2, "180/110", 115, 25, 39.2, 88.0, 250.0);
        
        // Upload vitals to patient and database
        System.out.println("Uploading vital signs for patients...");
        patient1.uploadVitals(vitals1);
        patient1.uploadVitals(vitals2);
        patient2.uploadVitals(vitals3);
        
        // Get vital history for Patient 1
        System.out.println("\nVital History for " + patient1.getName() + ":");
        for (VitalSign vital : patient1.getVitalHistory()) {
            System.out.println("Date: " + vital.getReportDate());
            System.out.println("Blood Pressure: " + vital.getBloodPressure());
            System.out.println("Heart Rate: " + vital.getHeartRate());
            System.out.println("Temperature: " + vital.getTemperature());
            System.out.println();
        }
        
        // Test Part 3: Emergency Alert System
        System.out.println("=== PART 3: EMERGENCY ALERT SYSTEM ===");
        
        // Add critical vitals to trigger emergency alert
        System.out.println("Adding critical vitals to patient " + patient2.getName());
        
        // First upload critical vitals to the patient and database
        patient2.uploadVitals(criticalVitals);
        
        // Manually add patient to critical patients list for testing purposes
        VitalsDatabase.getInstance().addCriticalPatient(patient2);
        
        // Test emergency alert for critical patient
        System.out.println("\nTesting automatic emergency alert for critical vitals:");
        EmergencyAlert.sendEmergencyAlert(patient2);
        
        // Test custom emergency alert
        System.out.println("\nTesting custom emergency alert:");
        EmergencyAlert.sendEmergencyAlert(patient2, "Urgent Medical Attention", 
                                        "Patient requires immediate medical intervention due to high blood pressure and fever.");
        
        // Test panic button
        System.out.println("\nTesting panic button functionality:");
        Panic_button panicButton = new Panic_button(patient2);
        panicButton.resetButton(); // First reset to ensure button can be pressed
        panicButton.pressButton();
        
        // Test pressing panic button again without reset
        System.out.println("\nTesting panic button pressed again without reset:");
        panicButton.pressButton();
        
        // Reset panic button
        panicButton.resetButton();
        System.out.println("Panic button has been reset");
        
        // Test Part 4: Notifications & Reminders
        System.out.println("\n=== PART 4: NOTIFICATIONS & REMINDERS ===");
        
        // Test email notification
        System.out.println("Testing email notification:");
        EmailNotification.sendNotification(patient1, "Test Email", "This is a test email notification.");
        
        // Test SMS notification
        System.out.println("\nTesting SMS notification:");
        SMSNotification.sendNotification(patient1, "Test SMS", "This is a test SMS notification.");
        
        // Create prescription for medication reminder
        HashMap<String, String> medications = new HashMap<>();
        medications.put("Lisinopril", "10mg once daily");
        medications.put("Aspirin", "81mg once daily");
        Prescription prescription = new Prescription("RX001", medications, "30 days", "Take with food");
        
        // Add prescription to patient
        patient1.addPrescription(prescription);
        
        // Create appointment for reminder
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(3);
        Appointment appointment = new Appointment("A001", patient1.getPatient_id(),
                                                doctor.getDoctorId(), appointmentDateTime,
                                                "Regular Check-up", "Scheduled", 100.0, 30);
        
        // Add appointment to patient
        patient1.addAppointment(appointment);
        
        // Test appointment reminder
        System.out.println("\nTesting appointment reminder:");
        RemainderService.appointment_remainder(patient1, "Upcoming Appointment", "Please arrive 15 minutes before your scheduled time.");
        
        // Test medication reminder
        System.out.println("\nTesting medication reminder:");
        RemainderService.medication_remainder(patient1, "Medication Reminder", "Don't forget to take your medication as prescribed.");
        
        // Test Part 5: Chat & Video Consultation
        System.out.println("\n=== PART 5: CHAT & VIDEO CONSULTATION ===");
        
        // Create chat server for the patient
        ChatServer chatServer = new ChatServer(patient1);
        
        // Create chat client for doctor-patient communication
        ChatClient chatClient = new ChatClient(doctor, patient1);
        
        // Add chat to server
        chatServer.addChat(chatClient);
        
        // Simulate chat conversation
        System.out.println("Testing chat functionality:");
        chatClient.messageByDoctor("Hello John, how are you feeling today?");
        chatClient.messageByPatient("Hello Dr. Johnson, I'm feeling much better after taking the medication.");
        chatClient.messageByDoctor("That's great to hear! Have you been monitoring your blood pressure?");
        chatClient.messageByPatient("Yes, it's been stable around 120/80.");
        
        // Show chat history
        System.out.println("\nChat History:");
        chatClient.showChatHistory();
        
        // Create video call
        System.out.println("\nTesting video call functionality:");
        VideoCall videoCall = new VideoCall(doctor, patient1, "https://meet.hospital.com/dr-johnson-john", new Date());
        
        // Add video call to chat server
        chatServer.addVideoCall(videoCall);
        
        // Simulate video call
        videoCall.startCall();
        
        // Wait a second to simulate call duration
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        videoCall.endCall();
        
        // Show all video calls
        System.out.println("\nAll Video Calls for " + patient1.getName() + ":");
        chatServer.showAllVideoCalls();
        
        System.out.println("\n=== TEST PROGRAM COMPLETED SUCCESSFULLY ===");
    }
}