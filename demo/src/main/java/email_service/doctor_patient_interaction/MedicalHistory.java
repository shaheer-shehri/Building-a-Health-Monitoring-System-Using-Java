package email_service.doctor_patient_interaction;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import email_service.usermanagement.Patient;

public class MedicalHistory {
    private Patient patient;
    private HashMap<String,ArrayList<Feedback>> previousRecords;
    // constructor to initialize the patient id and the previous records
    public MedicalHistory(Patient patient){
        this.patient = patient;
        this.previousRecords = new HashMap<String,ArrayList<Feedback>>();
    }
    // to add the feedback in medical record of patient which contains the list of its prescriptions and feedbacks
    public void addFeedback(Feedback feedback){
        if (this.previousRecords.containsKey(feedback.getFeedbackId())){
            this.previousRecords.get(feedback.getFeedbackId()).add(feedback);
        } else {
            ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
            feedbacks.add(feedback);
            this.previousRecords.put(feedback.getFeedbackId(), feedbacks);
        }
    }
    // to get the feedbacks and prescriptions of the patient
    public void getMedicalHistory(){
        System.out.println("Patient ID: " + this.patient.getName());
        for (String key : this.previousRecords.keySet()){
            System.out.println("Feedback ID: " + key);
            for (Feedback feedback : this.previousRecords.get(key)){
                feedback.getFeedbackDetails();
            }
        }
    }
    // to get the feedbacks of the patient by its id
    public List<Feedback> getFeedbackList(String patientId){
        if (this.previousRecords.containsKey(patientId)){
            return this.previousRecords.get(patientId);
        }
        else{
            ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
            this.previousRecords.put(patientId, feedbacks);
            return feedbacks;
        }
    }
}