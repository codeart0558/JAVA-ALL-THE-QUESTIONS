// # 3. Create a HashTable/ HashMap of students object and find the following:
// # a. Check if a particular key exist in the hashtable or not. If exist then display the value
// # b. Remove an entry from hashtable (key is entered by user to remove)
// # c. Add a new entry
// # d. Display all the entries 
// # e. Check if a particular value exist in the hashtable or not. If exist then display the value

import java.util.*;

class Student {
    private int studentId;
    private String name;
    private int age;

    // Constructor
    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString to display Student details
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Age: " + age;
    }
}

public class StudentHashMapExample {
    public static void main(String[] args) {
        // Create a HashMap with Integer as key and Student as value
        HashMap<Integer, Student> studentMap = new HashMap<>();

        // Add some initial entries to the HashMap
        studentMap.put(101, new Student(101, "Alice", 20));
        studentMap.put(102, new Student(102, "Bob", 22));
        studentMap.put(103, new Student(103, "Charlie", 21));
        studentMap.put(104, new Student(104, "Diana", 23));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Menu for user input
            System.out.println("\nMenu:");
            System.out.println("1. Check if a particular key exists");
            System.out.println("2. Remove an entry by key");
            System.out.println("3. Add a new entry");
            System.out.println("4. Display all entries");
            System.out.println("5. Check if a particular value exists");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character after integer input

            switch (choice) {
                case 1:
                    // Check if a particular key exists
                    System.out.print("Enter student ID to check: ");
                    int checkKey = sc.nextInt();
                    if (studentMap.containsKey(checkKey)) {
                        System.out.println("Student with ID " + checkKey + ": " + studentMap.get(checkKey));
                    } else {
                        System.out.println("Student with ID " + checkKey + " does not exist.");
                    }
                    break;

                case 2:
                    // Remove an entry by key
                    System.out.print("Enter student ID to remove: ");
                    int removeKey = sc.nextInt();
                    if (studentMap.remove(removeKey) != null) {
                        System.out.println("Student with ID " + removeKey + " removed.");
                    } else {
                        System.out.println("Student with ID " + removeKey + " does not exist.");
                    }
                    break;

                case 3:
                    // Add a new entry
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();

                    studentMap.put(id, new Student(id, name, age));
                    System.out.println("Student added successfully.");
                    break;

                case 4:
                    // Display all entries
                    System.out.println("Displaying all students:");
                    for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 5:
                    // Check if a particular value exists
                    System.out.print("Enter student name to check: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Student student : studentMap.values()) {
                        if (student.getName().equals(searchName)) {
                            System.out.println("Student found: " + student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with name " + searchName + " not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
