package model.entity.users.extend;

import model.entity.users.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Staff extends User {
    private String education;
    private String jobTitle;
    private double salary;
    private Date birthDay;
    private String address;

    public Staff(String type, String fullName, String phoneNumber, String email, String password) {
        super(type, fullName, phoneNumber, email, password);
    }

    public Staff(String type, String fullName, String phoneNumber, String email, String password, String education,
                 String jobTitle, double salary, Date birthDay, String address) {
        super(type, fullName, phoneNumber, email, password);
        this.education = education;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.birthDay = birthDay;
        this.address = address;
    }

    public Staff(long id, String type, String fullName, String phoneNumber, String email, String password, double wallet, String education, String jobTitle, double salary, Date birthDay, String address) {
        super(id, type, fullName, phoneNumber, email, password, wallet);
        this.education = education;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.birthDay = birthDay;
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthDay() {
        return new SimpleDateFormat("dd/MM/yyyy").format(birthDay);
    }

    public int getAge() {
        long timeBirthDay = birthDay.getTime();
        long timeNow = System.currentTimeMillis();
        final long TIME_OF_YEAR = 1000L * 60 * 60 * 24 * 365;
        return ((int) ((timeNow - timeBirthDay) / TIME_OF_YEAR));
    }

    public void setBirthDay(String strBirthDay) throws ParseException {
        this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(strBirthDay);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
