package email_service.doctor_patient_interaction;
import java.util.HashMap;

public class Prescription {
    private String prescription_id;
    private HashMap<String, String> medicationDosage;
    private String duration;
    private String notes;
    // constructor to initialize the prescription id, medication dosage, duration and notes
    public Prescription(String prescription_id,HashMap<String,String> medications, String duration, String notes) {
        this.prescription_id = prescription_id;
        this.duration = duration;
        this.notes = notes;
        this.medicationDosage = new HashMap<String, String>();
        for (String key : medications.keySet()) {
            this.medicationDosage.put(key, medications.get(key));
        }
    }
    // getters and setters for the prescription id, medication dosage, duration and notes
    public void setPrescriptionId(String prescription_id){
        this.prescription_id = prescription_id;
    }
    public String getPrescriptionId(){
        return this.prescription_id;
    }
    public void setMedicationDosage(HashMap<String,String> medicationDosage){
        this.medicationDosage = medicationDosage;
    }
    //  to get the medication dosage of the prescription using loop
    public void getMedicationDosage(){
        for (String key : this.medicationDosage.keySet()){
            System.out.println(key + ": " + this.medicationDosage.get(key));
        }
    }
    public void setDuration(String duration){
        this.duration = duration;
    }
    public String getDuration(){
        return this.duration;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public String getNotes(){
        return this.notes;
    }
    // to copy the prescription details from one prescription to another
    public void copyPrescription(Prescription prescription){
        this.prescription_id = prescription.getPrescriptionId();
        this.medicationDosage = prescription.medicationDosage;
        this.duration = prescription.getDuration();
        this.notes = prescription.getNotes();
    }
    // to print the prescription details in the list
    public void getPrescriptionDetails(){
        System.out.println("Prescription ID: " + this.prescription_id);
        System.out.println("Medication Dosage: ");
        for (String key : this.medicationDosage.keySet()){
            System.out.println(key + ": " + this.medicationDosage.get(key));
        }
        System.out.println("Duration: " + this.duration);
        System.out.println("Notes: " + this.notes);
    }
}
