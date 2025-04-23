package email_service.notification_remainders;
import email_service.usermanagement.Patient;

public class RemainderService{
    public static void appointment_remainder(Patient user, String subject, String body) {
        // Simulate sending an appointment reminder
        System.out.println("Sending appointment reminder to: " + user.getName());
        EmailNotification.sendNotification(user, "Appointment Remainder", "Your appointment is scheduled for: " + user.getAppointmentsDetail() + "\n" + body);
    }
    public static void medication_remainder(Patient user, String subject, String body) {
        // Simulate sending a medication reminder
        System.out.println("Sending medication reminder to: " + user.getName());
        EmailNotification.sendNotification(user, "Medication Remainder", "Your medication is due: " + user.getMedicationDetails() + "\n" + body);
    }
}
