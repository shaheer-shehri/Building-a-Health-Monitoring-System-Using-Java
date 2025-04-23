package email_service.usermanagement;
import java.time.LocalDate;
public abstract class User {
    private final String user_id;
    private String name;
    private String email_address;
    private String password;
    private String phone_no;
    private String address;
    private LocalDate date_of_birth;
    private int year_of_birth;
    private int month_of_birth;
    private int day_of_birth;
    // Constructor for User class which is super of class of 3 sub classes
    public User(String user_id, String name, String email_address, String password, String phone_no, String address, int year_of_birth, int month_of_birth, int day_of_birth) {
        this.user_id = user_id;
        this.name = name;
        this.email_address = email_address;
        this.password = password;
        this.phone_no = phone_no;
        this.address = address;
        this.year_of_birth = year_of_birth;
        this.month_of_birth = month_of_birth;
        this.day_of_birth = day_of_birth;
    }
    // Getters and Setters for User class attributes
    public String getUser_id() {
        return this.user_id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        if (name == null || name.length() < 3) {
            System.out.println("Name must be at least 3 characters long");
        }
        else
            this.name = name;
    }
    public String getEmail_address() {
        return this.email_address;
    }
    public void setEmail_address(String email_address) {
        if (email_address == null || !email_address.contains("@")) {
            System.out.println("Invalid email");
        }
        else
            this.email_address = email_address;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("Password must be at least 8 characters long");
        }
        else
            this.password = password;
    }
    public String getPhone_no() {
        return this.phone_no;
    }
    public void setPhone_no(String phone_no) {
        if (phone_no == null || phone_no.length() != 11) {
            System.out.println("Invalid phone number");
        }
        else
            this.phone_no = phone_no;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDate_of_birth() {
        return this.date_of_birth;
    }
    // setting the date of birth with validations on date, month and year
    public void setDate_of_birth(int year, int month, int day){
        if (year < 1900 || year > 2025 || month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid date of birth");
        }
        else
            this.date_of_birth = LocalDate.of(year, month, day);
    }
    public abstract void displayUser();
}
