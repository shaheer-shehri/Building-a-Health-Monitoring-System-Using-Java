package email_service.emergency_alert_system;
import email_service.health_data_handling.VitalsDatabase;
import email_service.usermanagement.Patient;

public class EmergencyAlert {
    // the method is static so no object is needed to use the method
    // it only requires the patient object to send the alert
    public static void sendEmergencyAlert(Patient patientId){
        VitalsDatabase database = VitalsDatabase.getInstance();
        // the method works for the patients who have more than 3 vital signs so their emails can be send autonumously
        if (database.getCriticalPatientsIds().contains(patientId) && database.checkNumberOfVitalSigns(patientId) > 3) {
            String subject = "Emergency Alert for Patient: " + patientId;
            String body = "Critical condition detected for patient: " + patientId.getName();
            String email = patientId.getEmail_address();
            NotificationService.sendEmail(patientId, subject, body);
            System.out.println("Emergency alert sent to: " + email);
        }
    }
    // overloaded the method with parameters for the alert type to include in the subject of email and message to include in body
    public static void sendEmergencyAlert(Patient patientId,String alertType,String message){
        VitalsDatabase database = VitalsDatabase.getInstance();
        // if the method is called and patient had any vial sign it will send an email and alert
        if (database.getCriticalPatientsIds().contains(patientId) && database.checkNumberOfVitalSigns(patientId) > 0) {
            String subject = alertType + " by " + patientId.getName();
            String body = message;
            String email = patientId.getEmail_address();
            NotificationService.sendEmail(patientId, subject, body);
            System.out.println("Emergency alert sent to: " + email);
        }
        else {
            System.out.println("No emergency alert sent. Patient is not in critical condition or has no vital signs.");
        }
    }
}
