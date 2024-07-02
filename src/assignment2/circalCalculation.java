package assignment2;
abstract class Shape {
    abstract void draw();
    abstract double calculateArea();
}
class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class Square extends Shape {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }
    @Override
    double calculateArea() {
        return side * side;
    }
}
class Triangle extends Shape {
    private double base;
    private double height; 
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}
public class circalCalculation {
    public static void main(String[] args) {
        
        Shape circle = new Circle(9.0);
        Shape square = new Square(8.0);
        Shape triangle = new Triangle(5.0, 7.0);
        circle.draw();
        System.out.println("area of Circle: " + circle.calculateArea());
        square.draw();
        System.out.println("area of Square: " + square.calculateArea());
        triangle.draw();
        System.out.println("area of Triangle: " + triangle.calculateArea());
    }
}
