package email_service.emergency_alert_system;
import email_service.usermanagement.Patient;

public class Panic_button {
    private final Patient panic_Patient;
    private boolean isPressed = false;
    // constructor of the panic button class
    public Panic_button(Patient panic_Patient) {
        this.panic_Patient = panic_Patient;
        this.isPressed = false;
    }
    // if patient presses the button, it will send an emergency alert to the patient email and hospital
    public void pressButton(){
        // if the patient is allowed to send panic email by resetting its panic button
        // so patient may not send multiple alerts at once
        if (isPressed != false) {
            this.isPressed = true;
            System.out.println("Emergency alert: \n" + panic_Patient.getName() + " has pressed the panic button!");
            System.out.println("Sending emergency alert to: " + panic_Patient.getEmail_address());
            // panic button will work if patient is in critical patient or he has any vital signs
            EmergencyAlert.sendEmergencyAlert(panic_Patient, "Panic Button Alert", "Emergency alert: " + panic_Patient.getName() + " has pressed the panic button!");
        } else {
            System.out.println("Panic alert already sent.");
        }
    }
    // if hospital want to reset the panic button for the patient so he can send alerts again
    public void resetButton() {
        this.isPressed = false;
        System.out.println("Panic button reset for patient: " + panic_Patient.getName());
    }
}
