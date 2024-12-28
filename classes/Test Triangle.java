// i. Define a class called Triangle, which has constructor with three parameters,
// which are of type Cartesian Point.
// ii. Provide methods
// 1. to find the area and the perimeter of the Triangle,
// 2. a method display() to display the three Cartesian Points separated by ':'
// character,
// 3. a method move() to move the first Cartesian Point to the specified x, y
// location, the move should take care of relatively moving the other
// points as well,
// 4. a method called rotate, which takes two arguments, one is the Cartesian
// Point and other is the angle in clockwise direction.
// 5. Overload the move method to work with Cartesian Point as a
// parameter.
// iii. Now define a class called Test Triangle to test the various methods defined in
// the Triangle class. 
class CartesianPoint {
    double x, y;

    public CartesianPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Method to move the point by dx, dy
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}


class Triangle {
    CartesianPoint p1, p2, p3;

    public Triangle(CartesianPoint p1, CartesianPoint p2, CartesianPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // Helper method to calculate the distance between two points
    private double distance(CartesianPoint p1, CartesianPoint p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Method to calculate the area of the triangle
    public double area() {
        return Math.abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0;
    }

    // Method to calculate the perimeter of the triangle
    public double perimeter() {
        double side1 = distance(p1, p2);
        double side2 = distance(p2, p3);
        double side3 = distance(p3, p1);
        return side1 + side2 + side3;
    }

    // Method to display the points of the triangle
    public void display() {
        System.out.println("Points: " + p1 + " : " + p2 + " : " + p3);
    }

    // Method to move the entire triangle by dx and dy
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
        p3.move(dx, dy);
    }

    // Overloaded move method to move by a CartesianPoint
    public void move(CartesianPoint newPoint) {
        double dx = newPoint.x - p1.x;
        double dy = newPoint.y - p1.y;
        move(dx, dy);
    }

    // Method to rotate the triangle around a point (origin) by an angle (in degrees)
    public void rotate(CartesianPoint origin, double angle) {
        // Convert angle to radians
        double radians = Math.toRadians(angle);
        double cosAngle = Math.cos(radians);
        double sinAngle = Math.sin(radians);

        // Method to rotate a point around the origin
        CartesianPoint rotatePoint(CartesianPoint p) {
            double dx = p.x - origin.x;
            double dy = p.y - origin.y;
            double newX = origin.x + cosAngle * dx - sinAngle * dy;
            double newY = origin.y + sinAngle * dx + cosAngle * dy;
            return new CartesianPoint(newX, newY);
        }

        // Rotate the points of the triangle
        p1 = rotatePoint(p1);
        p2 = rotatePoint(p2);
        p3 = rotatePoint(p3);
    }
}
class TestTriangle {
    public static void main(String[] args) {
        // Create points for the triangle
        CartesianPoint p1 = new CartesianPoint(0, 0);
        CartesianPoint p2 = new CartesianPoint(4, 0);
        CartesianPoint p3 = new CartesianPoint(0, 3);

        // Create a triangle using these points
        Triangle triangle = new Triangle(p1, p2, p3);

        // Display the points of the triangle
        triangle.display();

        // Calculate and display the area and perimeter
        System.out.println("Area: " + triangle.area());
        System.out.println("Perimeter: " + triangle.perimeter());

        // Move the triangle
        triangle.move(2, 3);
        triangle.display();  // Display points after moving

        // Move the triangle by a Cartesian point
        CartesianPoint newPoint = new CartesianPoint(5, 5);
        triangle.move(newPoint);
        triangle.display();  // Display points after moving to a new point

        // Rotate the triangle around point (0, 0) by 90 degrees
        CartesianPoint origin = new CartesianPoint(0, 0);
        triangle.rotate(origin, 90);
        triangle.display();  // Display points after rotation
    }
}
