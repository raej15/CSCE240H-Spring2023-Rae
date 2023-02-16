package HW3redo;

public abstract class Shape {
    double area;
    double perimeter;
    String errorMessage;

    abstract double getArea();
    
    abstract double getPerimeter();

    String getErrorMessage() {
        return "error; invalid input";
    }
    
}