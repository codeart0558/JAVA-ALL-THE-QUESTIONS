
package flapack;

public class Flat {
    private String apartmentName;
    private int flatNo;
    private int noOfBedrooms;
    

    // Constructor
    public Flat(String apartmentName, int flatNo, int noOfBedrooms) {
        this.apartmentName = apartmentName;
        this.flatNo = flatNo;
        this.noOfBedrooms = noOfBedrooms;
    }

    // Method to display flat information
    public void dispFlatInfo() {
        System.out.println("Apartment Name: " + apartmentName);
        System.out.println("Flat Number: " + flatNo);
        System.out.println("Number of Bedrooms: " + noOfBedrooms);
    }

    // Main method to test Flat class
    public static void main(String[] args) {
        // Creating a Flat object
        Flat myFlat = new Flat("Greenwood Residency", 101, 3);
        myFlat.dispFlatInfo(); // Display flat information
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