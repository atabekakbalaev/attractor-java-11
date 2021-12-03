package step01;

import java.util.Calendar;

public class Employee {
    private String firstname;
    private String lastname;
    private int birthYear;
    private int yearJoined;

    public Employee() {}

    public Employee(String firstname, String lastname, int birthYear, int yearJoined) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
        this.yearJoined = yearJoined;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }
    public int getYearsOfExperience() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.yearJoined;
    }
    public String getFullInfo() {
        return this.toString() + "\nExperience=" + this.getYearsOfExperience();
    }
    @Override
    public String toString() {
        return "Employee info:\n" +
                "firstname='" + firstname + '\'' +
                "\nlastname='" + lastname + '\'' +
                "\nbirthYear=" + birthYear +
                "\nyearJoined=" + yearJoined;
    }
}
