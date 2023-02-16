package HW3redo;

public class OOGeometricPropertyCalculator {
    public static void main(String[] args) {
        Rectangle A = new Rectangle(8, 2);
        Triangle B = new Triangle(8, 2, 4, 5);
        Circle C = new Circle(5);

        System.out.println("area of rectangle A is: " + A.getArea());
        System.out.println("perimeter of rectangle A is: " + A.getPerimeter());
        System.out.println("area of triangle B is: " + B.getArea());
        System.out.println("perimeter of Triangle B is: " + B.getPerimeter());
        System.out.println("area of circle C is: " + C.getArea());
        System.out.println("perimeter of circle C is: " + C.getPerimeter());
    }
}
