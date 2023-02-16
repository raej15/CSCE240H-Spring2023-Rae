package HW3redo;

public class Triangle extends Shape {
    double side1;
    double side2;
    double base;
    double height;

    Triangle(double side1, double side2, double base, double height) {
        this.side1 = side1;
        this.side2 = side2;
        this.base = base;
        this.height = height;

    }
    @Override
    double getArea() {
        area = (this.base * this.height)/2;
        return area;
    }

    @Override
    double getPerimeter() {
        perimeter = this.side1 + this.side2 + this.base;
        return perimeter;
    }
}
