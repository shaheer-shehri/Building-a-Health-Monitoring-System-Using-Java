package email_service.appointment_scheduling;
import java.util.ArrayList;
import java.util.HashMap;
public class AppointmentManager {
    private static AppointmentManager instance;
    private HashMap<String,ArrayList<Appointment>> appointmentsRecord;
    // Singleton pattern to ensure only one instance of AppointmentManager exists
    private AppointmentManager(){
        this.appointmentsRecord = new HashMap<>();
    }
    // Method to get the single instance of AppointmentManager
    public static AppointmentManager getInstance(){
        if(instance == null){
            instance = new AppointmentManager();
        }
        return instance;
    }
    // Method to add an appointment
    public void addAppointment(Appointment appointment){
        if (appointment.getDoctorAvailability() == true){
            if(this.appointmentsRecord.containsKey(appointment.getPatientId())){
                this.appointmentsRecord.get(appointment.getPatientId()).add(appointment);
            }
            else{
                ArrayList<Appointment> newPatientRecord = new ArrayList<>();
                newPatientRecord.add(appointment);
                this.appointmentsRecord.put(appointment.getPatientId(),newPatientRecord);
            }
        }
        else{
            System.out.println("Doctor is not available");
        }
    }
    // Method to remove an appointment
    public void removeAppointment(String patientId, String appointmentId){
        if(this.appointmentsRecord.containsKey(patientId)){
            ArrayList<Appointment> patientAppointments = this.appointmentsRecord.get(patientId);
            for (Appointment appointment : patientAppointments){
                if(appointment.getAppointmentId().equals(appointmentId)){
                    patientAppointments.remove(appointment);
                    System.out.println("Appointment removed");
                    return;
                }
            }
            System.out.println("Appointment not found");
        }
        else{
            System.out.println("Patient not found");
        }
    }
    // method to print the appointment details using patient id
    public void checkAppointments(String patientId){
        if(this.appointmentsRecord.containsKey(patientId)){
            ArrayList<Appointment> patientAppointments = this.appointmentsRecord.get(patientId);
            for (Appointment appointment : patientAppointments){
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Doctor ID: " + appointment.getDoctorId());
                System.out.println("Date and Time: " + appointment.getDateTime());
                System.out.println("Appointment Type: " + appointment.getAppointmentType());
                System.out.println("Status: " + appointment.getStatus());
                System.out.println("Appointment Fee: " + appointment.getAppointmentFee());
                System.out.println("Duration: " + appointment.getDuration());
            }
        }
        else{
            System.out.println("Patient not found");
        }
    }
    // checking all appointments associated with the patinet
    public void checkAllAppointments(){
        for (String patientId : this.appointmentsRecord.keySet()){
            ArrayList<Appointment> patientAppointments = this.appointmentsRecord.get(patientId);
            for (Appointment appointment : patientAppointments){
                System.out.println("Patient ID: " + patientId);
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Doctor ID: " + appointment.getDoctorId());
                System.out.println("Date and Time: " + appointment.getDateTime());
                System.out.println("Appointment Type: " + appointment.getAppointmentType());
                System.out.println("Status: " + appointment.getStatus());
                System.out.println("Appointment Fee: " + appointment.getAppointmentFee());
                System.out.println("Duration: " + appointment.getDuration());
            }
        }
    }
    // to check all appointments associated with the doctor
    public void checkDoctorAppointments(String doctorId){
        for (String patientId : this.appointmentsRecord.keySet()){
            ArrayList<Appointment> patientAppointments = this.appointmentsRecord.get(patientId);
            for (Appointment appointment : patientAppointments){
                if(appointment.getDoctorId().equals(doctorId)){
                    System.out.println("Patient ID: " + patientId);
                    System.out.println("Appointment ID: " + appointment.getAppointmentId());
                    System.out.println("Doctor ID: " + appointment.getDoctorId());
                    System.out.println("Date and Time: " + appointment.getDateTime());
                    System.out.println("Appointment Type: " + appointment.getAppointmentType());
                    System.out.println("Status: " + appointment.getStatus());
                    System.out.println("Appointment Fee: " + appointment.getAppointmentFee());
                    System.out.println("Duration: " + appointment.getDuration());
                }
            }
        }
    }

}
