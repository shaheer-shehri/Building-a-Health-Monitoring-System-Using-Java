package email_service.doctor_patient_interaction;
import java.util.HashMap;

public class Feedback {
    private String feedback_id;
    private String feedback;
    private HashMap<String,Prescription> previousRecords;
    // constructor to initialize the feedback id, feedback and the previous records
    public Feedback(String feedback_id, String feedback) {
        this.feedback_id = feedback_id;
        this.feedback = feedback;
        this.previousRecords = new HashMap<String,Prescription>();
    }
    // getters and setters for the feedback id, feedback and the previous records
    public void setFeedbackId(String feedback_id){
        this.feedback_id = feedback_id;
    }
    public String getFeedbackId(){
        return this.feedback_id;
    }
    public void setPreviousRecords(String feedbackId,Prescription prescription){
        if (this.previousRecords.containsKey(feedbackId)){
            this.previousRecords.get(feedbackId).copyPrescription(prescription);
        }
        else {
            this.previousRecords.put(feedbackId, prescription);
        }
    }
    // to print the feedback details and the prescription details in the list
    public void getFeedbackDetails(){
        System.out.println("Feedback ID: " + this.feedback_id);
        System.out.println("Feedback: " + this.feedback);
        System.out.println("Prescription: ");
        this.previousRecords.get(this.feedback_id).getPrescriptionDetails();
    }
    public void copyFeedback(Feedback feedback){
        this.feedback_id = feedback.getFeedbackId();
        this.feedback = feedback.getFeedbackId();
        this.previousRecords.get(this.feedback_id).copyPrescription(feedback.previousRecords.get(feedback.getFeedbackId()));
    }
    // to get the feedbacks of the patient by its precription id
    public void addPrescription( Prescription prescription){
        if (this.previousRecords.containsKey(this.getFeedbackId())){
            this.previousRecords.get(this.getFeedbackId()).copyPrescription(prescription);
        }
        else {
            this.previousRecords.put(this.getFeedbackId(), prescription);
        }
    }

}
