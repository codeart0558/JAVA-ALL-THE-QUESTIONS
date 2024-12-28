// a. Step-1 :
// i. Define a class called Cartesian Point, which has two instance variables, x and y.
// Provide the following methods
// 1. get X() and get Y() to return the values of the x and y values respectively.
// 2. move() which would take two integers as parameters and change the
// values of x and y respectively,
// 3. a method called display() which would display the current values of x
// and y.
// ii. Now overload the method move() to work with single parameter, which would
// set both x and y to the same values, .
// iii. Provide constructors with two parameters and overload to work with one
// parameter as well.
// iv. Now define a class called Test Cartesian Point, with the main method to test the
// various methods in the Cartesian Point class.


// Define the CartesianPoint class
class CartesianPoint {
    private int x; // Instance variable for x-coordinate
    private int y; // Instance variable for y-coordinate

    // Constructor with two parameters
    public CartesianPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Overloaded constructor with one parameter
    public CartesianPoint(int value) {
        this.x = value;
        this.y = value;
    }

    // Method to get the value of x
    public int getX() {
        return x;
    }

    // Method to get the value of y
    public int getY() {
        return y;
    }

    // Method to move the point with two parameters
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Overloaded method to move the point with one parameter
    public void move(int value) {
        this.x = value;
        this.y = value;
    }

    // Method to display the current values of x and y
    public void display() {
        System.out.println("Current Point: (" + x + ", " + y + ")");
    }
}

// Define the TestCartesianPoint class to test the CartesianPoint class
public class TestCartesianPoint {
    public static void main(String[] args) {
        // Create a CartesianPoint object using the two-parameter constructor
        CartesianPoint point1 = new CartesianPoint(2, 3);
        point1.display(); // Display initial point

        // Move the point using two parameters
        point1.move(3, 4);
        point1.display(); // Display after moving

        // Move the point using the overloaded single-parameter method
        point1.move(5);
        point1.display(); // Display after moving

        // Create a CartesianPoint object using the one-parameter constructor
        CartesianPoint point2 = new CartesianPoint(7);
        point2.display(); // Display the new point
    }
}
