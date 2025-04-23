package email_service.notification_remainders;
import email_service.usermanagement.User;

public class SMSNotification implements Notifiable {
    public static void sendNotification(User user, String subject, String body) {
        // Simulate sending an SMS notification
        System.out.println("Sending SMS to " + user.getName() + ": \n" + body);
    }
}
