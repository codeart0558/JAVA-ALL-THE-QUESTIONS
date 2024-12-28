// 1. Write a program to read employee detail and store the employee object in linkedlist. Sort the 
// list based on salary.
// a. Create class- Employee (Attributes- empid, name , dob , salary : Methods: setDetails, 
// getDetails and constructures )
// b. Employee class must implement comparable interface
// c. Create another class TestEmployee, here create the linkedlist of employees and sort the 
// list.
import java.util.*;

// Employee class
class Employee implements Comparable<Employee> {
    private int empId;
    private String name;
    private String dob; // Date of Birth as a string for simplicity
    private double salary;

    // Constructor
    public Employee(int empId, String name, String dob, double salary) {
        this.empId = empId;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    // Setters
    public void setDetails(int empId, String name, String dob, double salary) {
        this.empId = empId;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    // Getters
    public String getDetails() {
        return "ID: " + empId + ", Name: " + name + ", DOB: " + dob + ", Salary: " + salary;
    }

    // Comparable implementation (sorting by salary)
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
}

// TestEmployee class
public class CollectionFirst {
    public static void main(String[] args) {
        // Create LinkedList of Employees
        LinkedList<Employee> employees = new LinkedList<>();

        // Adding employee details
        employees.add(new Employee(101, "Alice", "1990-01-15", 60000));
        employees.add(new Employee(102, "Bob", "1985-03-22", 50000));
        employees.add(new Employee(103, "Charlie", "1992-07-18", 70000));
        employees.add(new Employee(104, "Diana", "1988-11-05", 55000));

        // Sorting the LinkedList based on salary
        Collections.sort(employees);

        // Displaying sorted employee details
        System.out.println("Employee details sorted by salary:");
        for (Employee emp : employees) {
            System.out.println(emp.getDetails());
        }
    }
}
