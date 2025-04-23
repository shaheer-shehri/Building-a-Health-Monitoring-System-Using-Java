package email_service.appointment_scheduling;
import java.time.LocalDateTime;
public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDateTime dateTime;
    private String appointmentType;
    private String status;
    private double appointmentFee;
    private int duration;
    private Boolean doctorAvailable = true;
    // Constructor to set the appointment details
    public Appointment(String appointmentId, String patientId,
        String doctorId, LocalDateTime dateTime, String appointmentType,
        String status, double appointmentFee, int duration) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.appointmentType = appointmentType;
        this.status = status;
        this.appointmentFee = appointmentFee;
        this.duration = duration;
    }
    // Getters and Setters for the appointment details
    public void setDoctorLeave(){
        this.doctorAvailable = false;
    }
    public Boolean getDoctorAvailability(){
        return this.doctorAvailable;
    }
    public void setDoctorAvailability(Boolean doctorAvailable){
        this.doctorAvailable = doctorAvailable;
    }
    public void setPatientId(String patientID){
        this.patientId = patientID;
    }
    public String getPatientId(){
        return this.patientId;
    }
    public void setDoctorId(String DoctorId){
        this.doctorId = DoctorId;
    }
    public String getDoctorId(){
        return this.doctorId;
    }
    public void setDateTime(LocalDateTime datetime){
        this.dateTime = datetime;
    }
    public LocalDateTime getDateTime(){
        return this.dateTime;
    }
    public String getAppointmentId(){
        return this.appointmentId;
    }
    public void setAppointmentId(String AppointmentId){
        this.appointmentId = AppointmentId;
    }
    public String getAppointmentType(){
        return this.appointmentType;
    }
    public void setAppointmentType(String AppointmentType){
        this.appointmentType = AppointmentType;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String Status){
        this.status = Status;
    }
    public Double getAppointmentFee(){
        return this.appointmentFee;
    }
    public void setAppointmentFee(Double AppointmentFee){
        this.appointmentFee = AppointmentFee;
    }
    public int getDuration(){
        return this.duration;
    }
    public void setDuration(int Duration){
        this.duration = Duration;
    }
}
