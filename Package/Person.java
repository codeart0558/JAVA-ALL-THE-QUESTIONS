
package personpack;

import flapack.Flat;

 public class Person {  // Make the class public
    public int PIDNumber;
    public String name;
    public Flat flat; // Reference to the Flat object

    // Constructor
    public Person(int PIDNumber, String name, Flat flat) {
        this.PIDNumber = PIDNumber;
        this.name = name;
        this.flat = flat;
    }

    // Static method to display ownership information
    public static void displayOwnershipInfo(int PIDNumber, Person person) {
        System.out.println("Displaying ownership information:");
        System.out.println("Person ID: " + PIDNumber);
        System.out.println("Name: " + person.name);
        if (person.flat != null) {
            person.flat.dispFlatInfo(); // Call the Flat's method
        } else {
            System.out.println("No flat information available.");
        }
    }

    // Main method to test Person class
    public static void main(String[] args) {
        // Create a Flat object
        Flat myFlat = new Flat("Greenwood Residency", 101, 3);

        // Create a Person object with a reference to the Flat
        Person person = new Person(12345, "John Doe", myFlat);

        // Invoke the static method displayOwnershipInfo
        displayOwnershipInfo(12345, person);
    }
}




/*  javac -d . Flat.java
PS D:\university> java flapack.Flat
Apartment Name: Greenwood Residency
Flat Number: 101
PS D:\university> java personpack.Person
Displaying ownership information:
Name: John Doe
Apartment Name: Greenwood Residency
Flat Number: 101
Number of Bedrooms: 3
PS D:\university> javac -d . Pfdemo.java
PS D:\university> java pfpack.Pfdemo
Error: Could not find or load main class pfpack.Pfdemo
Caused by: java.lang.NoClassDefFoundError: pfpack/Pfdemo (wrong name: pfpack/PFDemo)
PS D:\university> java pfpack.PFDemo
Displaying ownership information:
Person ID: 12345
Name: John Doe
Apartment Name: Greenwood Residency
Flat Number: 101
Number of Bedrooms: 3
PS D:\university> */