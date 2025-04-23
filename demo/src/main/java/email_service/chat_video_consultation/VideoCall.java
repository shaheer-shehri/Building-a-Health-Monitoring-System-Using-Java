package email_service.chat_video_consultation;
import java.util.Date;

import email_service.usermanagement.Doctor;
import email_service.usermanagement.Patient;

public class VideoCall {
    // attributes to store the call details
    private Doctor doctor;
    private Patient patient;
    private String callLink;
    private Date startTime;
    private Date endTime;
    // constructor to initialize the call details
    public VideoCall(Doctor doctor, Patient patient, String callLink, Date startTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.callLink = callLink;
        this.startTime = new Date(); // Initialize startTime to the current date and time
    }
    // methods to start call
    public void startCall() {
        System.out.println("Video call started with " + doctor.getName() + " at " + startTime);
        System.out.println("Call link: " + callLink);
    }
    // method to end call
    public void endCall() {
        endTime = new Date(); // Set the end time to the current date and time
        System.out.println("Video call ended with " + doctor.getName());
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    // to access the call link
    public String getCallLink() {
        return callLink;
    }
    public Date getStartTime() {
        return startTime;
    }
    public Date getEndTime() {
        return endTime;
    }

}
