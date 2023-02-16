package HW3redo;

public class Rectangle extends Shape {
    double length;
    double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double getArea() {
        area = this.length * this.breadth;
        return area;
    }

    @Override
    double getPerimeter() {
        perimeter = 2*(this.length + this.breadth);
        return perimeter;
    }
}
