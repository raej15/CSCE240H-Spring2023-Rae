package HW3redo;

public class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double getArea() {
        area = 3.14 * this.radius * this.radius;
        return area;
    }

    @Override
    double getPerimeter() {
        perimeter = 3.14 * 2 * this.radius;
        return perimeter;
    }
}
