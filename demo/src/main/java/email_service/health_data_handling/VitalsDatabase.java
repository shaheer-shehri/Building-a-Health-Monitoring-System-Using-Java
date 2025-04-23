package email_service.health_data_handling;
import java.util.ArrayList;
import java.util.HashMap;

import email_service.usermanagement.Patient;
public class VitalsDatabase {
    private static VitalsDatabase onlyInstance;
    private HashMap<Patient, ArrayList<VitalSign>> patientsRecords;
    private ArrayList<Patient> critical_Patients;
    // to restrict user to create only a single database file while running an app i set the constructor to private
    // and created a static method to get the instance of this class
    private VitalsDatabase(){
        this.patientsRecords = new HashMap<>();
        this.critical_Patients = new ArrayList<>();
    }
    // singleton pattern to restrict user to create only a single database file while running an app
    public static VitalsDatabase getInstance(){
        if (onlyInstance == null){
            onlyInstance = new VitalsDatabase();
        }
        return onlyInstance;
    }
    // this method is used to add a new vital sign to the database
    // if the patient already exists in the database then it will add the new vital sign to the existing record
    public void addVitalSign(VitalSign vitalSign){
        if(this.patientsRecords.containsKey(vitalSign.getPatient())){
            this.patientsRecords.get(vitalSign.getPatient()).add(vitalSign);
        }
        else{
            ArrayList<VitalSign> newPatientRecord = new ArrayList<>();
            newPatientRecord.add(vitalSign);
            this.patientsRecords.put(vitalSign.getPatient(),newPatientRecord);
        }
    }
    // this method is used to get the vital signs of a patient from the database it prints the record
    public void getPatientRecords(Patient PatientId){
        if (this.patientsRecords.containsKey(PatientId)){
            ArrayList<VitalSign> patientSigns = new ArrayList<>() ;
            patientSigns = this.patientsRecords.get(PatientId);
            for(VitalSign sign: patientSigns){
                System.out.println(sign.toString());
            }
        }
        else{
            System.out.println("No records found for this patient");
        }
    }
    // this method is used to get the vital signs of all patients from the database it prints the record
    public void getCriticalPatients(){
        for (Patient patient: this.patientsRecords.keySet()){
            if (this.patientsRecords.get(patient).size() > 5){
                this.addCriticalPatient(patient);
            }
        }
        for(Patient patientId: this.critical_Patients){
            System.out.println(patientId);
        }
    }
    public ArrayList<Patient> getCriticalPatientsIds(){
        return this.critical_Patients;
    }
    // to set the critical patients in the database
    // this method is also used to add a new critical patient to the database
    public void addCriticalPatient(Patient patientId){
        this.critical_Patients.add(patientId);
    }
    public void removeCriticalPatients(Patient patientId){
        this.critical_Patients.remove(patientId);
    }
    // to get only numbers of the diagnosed vital signs of a patient
    public int checkNumberOfVitalSigns(Patient patientId){
        ArrayList<VitalSign> patientSigns = new ArrayList<>();
        patientSigns = this.patientsRecords.get(patientId);
        if (patientSigns == null) {
            return 0;
        }
        return patientSigns.size();
    }
    // to get the vital sign of a patient by index
    public VitalSign getVitalSign(Patient patientId, int index){
        if (index > 0 && index < this.checkNumberOfVitalSigns(patientId)  ){
            ArrayList<VitalSign> patientSigns = new ArrayList<>();
            patientSigns = this.patientsRecords.get(patientId);
            return patientSigns.get(index);
        }
        else{
            System.out.println(patientId + " has no records for given data");
            return null;
        }
    }
    // to add the vital sign of a patient by the patient id in the history
    public void addVitalSign(Patient patientId,VitalSign vitalSign){
        if (this.patientsRecords.containsKey(patientId)){
            this.patientsRecords.get(patientId).add(vitalSign);
        }
        else{
            System.out.println("No records found for this patient");
        }
    }
}
