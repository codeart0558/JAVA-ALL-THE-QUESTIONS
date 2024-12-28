package pfpack;

import personpack.Person;
import flapack.Flat;

class PFDemo {
    public static void main(String[] args) {
        // Create a Flat object
        Flat myFlat = new Flat("Greenwood Residency", 101, 3);

        // Create a Person object with a reference to the Flat
        Person person = new Person(12345, "John Doe", myFlat);

        // Invoke the static method displayOwnershipInfo
        Person.displayOwnershipInfo(12345, person);
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