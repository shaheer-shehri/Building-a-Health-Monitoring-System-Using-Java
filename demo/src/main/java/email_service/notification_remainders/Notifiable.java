package email_service.notification_remainders;
import email_service.usermanagement.User;

public interface Notifiable {
    static void sendNotification( User user, String subject,String body){
    }
}
