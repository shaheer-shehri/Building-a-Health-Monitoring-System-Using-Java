package email_service.chat_video_consultation;
import email_service.usermanagement.Patient;
import email_service.usermanagement.Doctor;
import java.util.ArrayList;

public class ChatClient {
    private Doctor doctor;
    private Patient patient;
    private ArrayList<String> chatHistory;

    public ChatClient(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        this.chatHistory = new ArrayList<>();
    }
    public void messageByDoctor(String message){
        chatHistory.add("Doctor: " + message);
        System.out.println("Doctor: " + message);
    }
    public void messageByPatient(String message){
        chatHistory.add("Patient: " + message);
        System.out.println("Patient: " + message);
    }
    public void showChatHistory(){
        System.out.println("Chat History:");
        for(String message : chatHistory){
            System.out.println(message);
        }
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }

}
