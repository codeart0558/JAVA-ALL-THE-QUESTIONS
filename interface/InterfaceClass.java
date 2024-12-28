/*
interface only contains ---> (abstract methods)
keyword -> Implement (archive interface in subcalss)
1)interface methods are by default public and abstract
2) interface variable are bydefault public ,static , final.
3) interface method must be override in the subclass

-----------
abstract class use abstarct keyword
// eg..abstract class A{}
1)we cant create a obbject of abstract class
2)dynamic method disptech
eg..
// abstract class animal{
// }
// class dog extends animal{
// }
// class demo{
// public sttaic void main(Strng[] args){
//   animal r = new dog();
// }
// }
3)it may contain abstract method or may not
4) to use abtract class ,you have o inherit it sub classes.
*/
/*
// a. Design an interface IFig having the following methods: 
// i. public void calcAreaQ; 
// ii. public void calcVolumeO; 
// iii. It must also have the variable pi of the type double and having a value 3.1428. 
// b. Design an abstract class called Figure. 
// i. It must have three attributes r. a and v of data type double. 
// ii. It has abstract methods: 
// 1. public abstract void dispAreaQ; 
// 2. public abstract void dispVolumeO; 
// c. Design three classes Cone, Sphere and Cylinder. Each of them, should 
// extend the Figure class and implement the IFig interface.
// ------------ 
// d. Write a test program to demonstrate polymorphism
// -----------
// ClassName Attribute 
// Cone --> h, s of the type double 
// Sphere ---> 
// Cylinder -->     h of the type double 

// ----
// box 2
// ----
// Figure Formulae 
// Cone --> Area =(pi*r*s)+(pi*r*r) --> Volume = (pi * r * r * h)/3 
// Sphere --> Area = 4 * p * r * r --> Volume = (4 * pj * r * r r) /3 
// Cylinder --> Area =(2*pi*r*r)+(2*pi*r*h) --> Volume = pi * r * r * h
*/
interface Ifig {
    double pi = 3.1428;
    
    // Method signatures with void return type
    public void calcAreaQ(); 
    public void calcVolumeO();
}

abstract class Figure {
    double r, a, v;

    // Abstract methods for displaying area and volume
    public abstract void dispAreaQ(); 
    public abstract void dispVolumeO();
}

class Cone extends Figure implements Ifig {
    double h, s;

    // Constructor to initialize values
    public Cone(double r, double h, double s) {
        this.r = r;
        this.h = h;
        this.s = s;
    }

    // Implement calcAreaQ for Cone
    public void calcAreaQ() {
        a = (pi * r * s) + (pi * r * r);  // Surface area of a cone
        System.out.println("Area of cone: " + a);
    }

    // Implement calcVolumeO for Cone
    public void calcVolumeO() {
        v = (pi * r * r * h) / 3;  // Volume of a cone
        System.out.println("Volume of cone: " + v);
    }

    // Override dispAreaQ to display the area
    public void dispAreaQ() {
        System.out.println("Area of Cone: " + a);
    }

    // Override dispVolumeO to display the volume
    public void dispVolumeO() {
        System.out.println("Volume of Cone: " + v);
    }
}

class Sphere extends Figure implements Ifig {

    // Constructor to initialize values
    public Sphere(double r) {
        this.r = r;
    }

    // Implement calcAreaQ for Sphere
    public void calcAreaQ() {
        a = 4 * pi * r * r;  // Surface area of a sphere
        System.out.println("Area of sphere: " + a);
    }

    // Implement calcVolumeO for Sphere
    public void calcVolumeO() {
        v = (4 * pi * r * r * r) / 3;  // Volume of a sphere
        System.out.println("Volume of sphere: " + v);
    }

    // Override dispAreaQ to display the area
    public void dispAreaQ() {
        System.out.println("Area of Sphere: " + a);
    }

    // Override dispVolumeO to display the volume
    public void dispVolumeO() {
        System.out.println("Volume of Sphere: " + v);
    }
}

class Cylinder extends Figure implements Ifig {
    double h;

    // Constructor to initialize values
    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    // Implement calcAreaQ for Cylinder
    public void calcAreaQ() {
        a = (2 * pi * r * r) + (2 * pi * r * h);  // Surface area of a cylinder
        System.out.println("Area of cylinder: " + a);
    }

    // Implement calcVolumeO for Cylinder
    public void calcVolumeO() {
        v = pi * r * r * h;  // Volume of a cylinder
        System.out.println("Volume of cylinder: " + v);
    }

    // Override dispAreaQ to display the area
    public void dispAreaQ() {
        System.out.println("Area of Cylinder: " + a);
    }

    // Override dispVolumeO to display the volume
    public void dispVolumeO() {
        System.out.println("Volume of Cylinder: " + v);
    }
}

public class TestPolymorphism {
    public static void main(String[] args) {
        // Create instances of the Cone, Sphere, and Cylinder
        Cone cone = new Cone(5, 10, 7);
        Sphere sphere = new Sphere(4);
        Cylinder cylinder = new Cylinder(3, 8);

        // Calculate and display area and volume using polymorphism
        Figure[] figures = { cone, sphere, cylinder };

        for (Figure figure : figures) {
            figure.calcAreaQ();
            figure.calcVolumeO();
            figure.dispAreaQ();
            figure.dispVolumeO();
            System.out.println();
        }
    }
}
