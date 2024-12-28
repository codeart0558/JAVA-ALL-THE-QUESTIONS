// 1. Define an Employee class with Employee code , name , date of birth , and date of 
// appointment . The Employee code must have a format of year-designation-number. The 
// year will be two digit code . The designation is single letter code M for Manager , A for 
// Administrative , T for Technical Staff , E for Executive Staff . The number is a three 
// digit number. For Eg.
//  87-M-123 ( year is 1987 , Designation is Manager and number is 123)
//  91-T-126
// Write a java program to read the employee code , name , date of birth , and date of 
// appointment and validate the employee code. If the employee code is incorrect a suitable 
// user defined exception must be thrown . If the date of birth is after date of appointment then 
// throw another user defined exception.
// If all the details are correct then only create the employee object and display detail of 
// employees and number of years of experience.import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.util.*;
// Custom Exception for Invalid Employee Code
class InvalidEmployeeCodeException extends Exception {
    public InvalidEmployeeCodeException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Dates
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// Employee Class
class Employee {
    private String employeeCode;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfAppointment;

    public Employee(String employeeCode, String name, LocalDate dateOfBirth, LocalDate dateOfAppointment)
            throws InvalidEmployeeCodeException, InvalidDateException {
        if (!validateEmployeeCode(employeeCode)) {
            throw new InvalidEmployeeCodeException("Invalid employee code: " + employeeCode);
        }

        if (dateOfBirth.isAfter(dateOfAppointment)) {
            throw new InvalidDateException("Date of birth cannot be after the date of appointment.");
        }

        this.employeeCode = employeeCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAppointment = dateOfAppointment;
    }

    private boolean validateEmployeeCode(String code) {
        // Regex for employee code: year-designation-number
        String regex = "\\d{2}-[MATE]-\\d{3}";
        return Pattern.matches(regex, code);
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Code: " + employeeCode);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Date of Appointment: " + dateOfAppointment);

        int experience = calculateExperience();
        System.out.println("Years of Experience: " + experience);
    }

    private int calculateExperience() {
        return Period.between(dateOfAppointment, LocalDate.now()).getYears();
    }
}

class EmployeeManagement {
      public static void main(String[] args) {
          try {
              // Input Details (Replace with Scanner for user input if needed)
              String employeeCode = "91-T-126";
              String name = "John Doe";
              String dob = "1980-05-15";
              String doa = "2005-08-20";
  
              // Parse dates
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              LocalDate dateOfBirth = LocalDate.parse(dob, formatter);
              LocalDate dateOfAppointment = LocalDate.parse(doa, formatter);
  
              // Create Employee Object
              Employee employee = new Employee(employeeCode, name, dateOfBirth, dateOfAppointment);
  
              // Display Employee Details
              employee.displayDetails();
  
          } catch (InvalidEmployeeCodeException | InvalidDateException e) {
              System.err.println("Error: " + e.getMessage());
          } catch (Exception e) {
              System.err.println("An unexpected error occurred: " + e.getMessage());
          }
      }
  }
