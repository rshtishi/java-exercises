package com.github.rshtishi;

public class Exercise20 {

    public static abstract class Shape {

        public abstract double calculatePerimeter();

        public abstract double calculateArea();
    }

    public static class Rectangle extends Shape {

        private int width;
        private int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * width + 2 * height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    public static class Triangle extends Shape {

        private int a;
        private int b;
        private int c;
        private int height;

        public Triangle(int a, int b, int c, int height) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.height = height;
        }

        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }

        @Override
        public double calculateArea() {
            return (c * height) / 2;
        }
    }

    public static class Hexagon extends Shape {

        private int side;
        private int height;

        public Hexagon(int side, int height) {
            this.side = side;
            this.height = height;
        }

        @Override
        public double calculatePerimeter() {
            return 6 * side;
        }

        @Override
        public double calculateArea() {
            return 3 * side * height;
        }
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 4);
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        Triangle triangle = new Triangle(5, 5, 5, 3);
        System.out.println("Triangle perimeter: " + triangle.calculatePerimeter());
        System.out.println("Triangle Area: " + triangle.calculateArea());

        Hexagon hexagon = new Hexagon(6, 3);
        System.out.println("Hexagon perimeter: " + hexagon.calculatePerimeter());
        System.out.println("Hexagon Area: " + hexagon.calculateArea());
    }
}
