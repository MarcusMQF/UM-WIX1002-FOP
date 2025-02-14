import java.util.Scanner;

public class L9Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.inputDimensions(scanner);
        rectangle.computePerimeterAndArea();
        rectangle.display();

        // Square
        System.out.println();
        Square square = new Square();
        square.inputDimensions(scanner);
        square.computePerimeterAndArea();
        square.display();

        // Circle
        System.out.println();
        Circle circle = new Circle();
        circle.inputDimensions(scanner);
        circle.computePerimeterAndArea();
        circle.display();

        scanner.close();
    }
}

class Shape {
    protected String name;
    protected double perimeter;
    protected double area;

    public Shape(String name) {
        this.name = name;
    }

    // Accessor methods
    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    // Mutator methods
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // Display method
    public void display() {
        System.out.printf("Shape: %s%nPerimeter: %.2f%nArea: %.2f%n", name, perimeter, area);
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle() {
        super("Rectangle");
    }

    public void inputDimensions(Scanner scanner) {
        System.out.print("Enter length of the rectangle: ");
        length = scanner.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        width = scanner.nextDouble();
    }

    public void computePerimeterAndArea() {
        perimeter = 2 * (length + width);
        area = length * width;
    }
}

class Square extends Shape {
    private double side;

    public Square() {
        super("Square");
    }

    public void inputDimensions(Scanner scanner) {
        System.out.print("Enter side length of the square: ");
        side = scanner.nextDouble();
    }

    public void computePerimeterAndArea() {
        perimeter = 4 * side;
        area = side * side;
    }
}

class Circle extends Shape {
    private double diameter;

    public Circle() {
        super("Circle");
    }

    public void inputDimensions(Scanner scanner) {
        System.out.print("Enter diameter of the circle: ");
        diameter = scanner.nextDouble();
    }

    public void computePerimeterAndArea() {
        double radius = diameter / 2;
        perimeter = 2 * Math.PI * radius;  // Circumference
        area = Math.PI * Math.pow(radius, 2);  // Area
    }
}
