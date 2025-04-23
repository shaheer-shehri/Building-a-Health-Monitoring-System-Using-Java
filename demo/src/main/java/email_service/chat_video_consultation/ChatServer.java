package email_service.chat_video_consultation;
import java.util.ArrayList;

import email_service.usermanagement.Patient;

public class ChatServer{
    private Patient patient;
    // server will record the details for the calls and messages of patient
    private ArrayList<ChatClient> chats;
    private ArrayList<VideoCall> videoCalls;

    public ChatServer(Patient patient) {
        this.patient = patient;
        this.chats = new ArrayList<>();
        this.videoCalls = new ArrayList<>();
    }
    // method to add chats with some doctor
    public void addChat(ChatClient chat) {
        chats.add(chat);
    }
    // method to remove chats with some doctor
    public void removeChat(ChatClient chat) {
        chats.remove(chat);
    }
    // methods to add and remove calls in history
    public void addVideoCall(VideoCall videoCall) {
        videoCalls.add(videoCall);
    }
    public void removeVideoCall(VideoCall videoCall) {
        videoCalls.remove(videoCall);
    }
    // method to show all the chats with doctors
    public void showAllVideoCalls() {
        System.out.println("All Video Calls:");
        for (VideoCall videoCall : videoCalls) {
            System.out.println("Video Call with " + videoCall.getDoctor().getName() + " at " + videoCall.getStartTime());
            System.out.println("Call link: " + videoCall.getCallLink());
        }
    }
    // method to show all the chats with doctors
    public void showAllChats() {
        System.out.println("All Chats:");
        for (ChatClient chat : chats) {
            System.out.println("Chat with " + chat.getDoctor().getName() + ":");
            chat.showChatHistory();
        }
    }
    public Patient getPatient() {
        return patient;
    }

}
