package email_service.emergency_alert_system;
import email_service.notification_remainders.EmailNotification;
import email_service.notification_remainders.SMSNotification;
import email_service.usermanagement.User;

public class NotificationService{
    // used the jakarta mail library to send the email
    // the method is static so no object is needed to use the method
    public static void sendEmail(User user, String subject, String body) {
        // the email and password are used to authenticate the sender's email account
        EmailNotification.sendNotification(user, subject, body);
    }
    // this method is used to send a message to the patient in case of emergency alert
    public static void sendMessage(User user,String subject ,String body) {
        SMSNotification.sendNotification(user, subject, body);
    }
}
