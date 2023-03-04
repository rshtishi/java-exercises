package com.github.rshtishi;

public class Exercise9Test {

    public static class Point2D {
        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    public static class Circle {

        private static final double PI = 3.14;
        private Point2D center;
        private Point2D point;

        public Circle(Point2D center, Point2D point) {
            this.center = center;
            this.point = point;
        }

        private double calculateRadius() {
            double dx2 = Math.pow((center.getX() - point.getX()), 2);
            double dy2 = Math.pow((center.getY() - point.getY()), 2);
            double radius = Math.sqrt(dx2 + dy2);
            return radius;
        }

        public double getRadius() {
            return calculateRadius();
        }

        public double getPerimeter() {
            return 2 * PI * calculateRadius();
        }

        public double getArea() {
            double radius = calculateRadius();
            return PI * Math.pow(radius, 2);
        }
    }


    public static void main(String[] args) {

        Circle circle = new Circle(new Point2D(1, 1), new Point2D(2, 2));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
