package graphicspackage;
abstract class Shape {
    // Abstract method to be implemented by concrete classes
    public abstract void print();
}

abstract class TwoDimensional extends Shape {
    // Abstract method for area calculation
    public abstract double area();
}

abstract class ThreeDimensional extends Shape {
    // Abstract method for volume calculation
    public abstract double volume();
}

// Square class - subclass of TwoDimensional
class Square extends TwoDimensional {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void print() {
        System.out.println("Shape: Square, Dimension: 2D");
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Circle class - subclass of TwoDimensional
class Circle extends TwoDimensional {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Shape: Circle, Dimension: 2D");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Cylinder class - subclass of ThreeDimensional
class Cylinder extends ThreeDimensional {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("Shape: Cylinder, Dimension: 3D");
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }
}

// Cube class - subclass of ThreeDimensional
class Cube extends ThreeDimensional {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public void print() {
        System.out.println("Shape: Cube, Dimension: 3D");
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

// Driver class
public class Grapgical {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = {
            new Square(4),
            new Circle(5),
            new Cylinder(3, 7),
            new Cube(3)
        };

        // Loop through the array and print the shape information
        for (Shape shape : shapes) {
            shape.print();  // Call the print method for the shape

            // Check if shape is an instance of TwoDimensional
            if (shape instanceof TwoDimensional) {
                TwoDimensional tdShape = (TwoDimensional) shape; // Casting to TwoDimensional
                System.out.println("Area: " + tdShape.area());
            }

            // Check if shape is an instance of ThreeDimensional
            if (shape instanceof ThreeDimensional) {
                ThreeDimensional tdShape = (ThreeDimensional) shape; // Casting to ThreeDimensional
                System.out.println("Volume: " + tdShape.volume());
            }
            System.out.println("------------------------------");
        }
    }
}


/* javac -d . Grapgical.java
PS D:\university> java graphicspackage.Grapgical
Shape: Square, Dimension: 2D
Area: 16.0
------------------------------
Shape: Circle, Dimension: 2D  
Area: 78.53981633974483       
------------------------------
Shape: Cylinder, Dimension: 3D
Volume: 197.92033717615698
------------------------------
Shape: Cube, Dimension: 3D
Volume: 27.0
------------------------------
PS D:\university> */