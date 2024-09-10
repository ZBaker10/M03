//circle class that extends GeometricObject and implements Comparable
public class Circle extends GeometricObject implements Comparable<Circle> {

    //radius field for Circle object
    private double radius;

    //constructor that initializes Circle with a specific radius
    public Circle(double radius) {
        this.radius = radius;
    }

    //default constructor that sets radius to 1.0
    public Circle() {
        this(1.0);
    }

    //getter method for radius
    public double getRadius() {
        return radius;
    }

    //setter method for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //calculate the area of the circle
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //calculate the circumference of the circle
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //calculate the diameter of the circle
    public double getDiameter() {
        return 2 * radius;
    }

    //compare two Circle objects based on their radius
    @Override
    public int compareTo(Circle otherCircle) {
        if (this.radius > otherCircle.radius) {
            return 1; // this Circle is larger
        } else if (this.radius < otherCircle.radius) {
            return -1; // this Circle is smaller
        } else {
            return 0; // both Circles are equal
        }
    }

    //check if two Circle objects have the same radius
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle otherCircle = (Circle) obj;
            return this.radius == otherCircle.radius;
        }
        return false;
    }

    //provide a string representation of the Circle object
    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}