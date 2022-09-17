package com.github.rshtishi;

public class Exercise9 {

    static class Point2D {
        private double x;
        private double y;

        public Point2D(int x, int y) {
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

    static class Circle implements Exercise10.Moveable, Exercise11.Resizable {

        public static final double PI = 3.14;
        private double radius;

        private Point2D center;
        private Point2D point;

        Circle(Point2D center, Point2D point) {
            this.center = center;
            this.point = point;
            this.radius = calculateRadius();
        }

        private double calculateRadius(){
            return Math.sqrt(Math.pow(center.getX() - point.getX(), 2) + Math.pow(center.getY() - point.getY(), 2)) / 2;
        }

        public double getRadius() {
            return radius;
        }

        public double getPerimeter() {
            return 2 * PI * getRadius();
        }

        public double getArea() {
            return PI * Math.pow(getRadius(), 2);
        }

        @Override
        public void move(Exercise10.MoveDirection moveDirection) {
            this.center.setX(this.center.getX() + moveDirection.getX());
            this.center.setY(this.center.getY() + moveDirection.getY());
            this.point.setX(this.point.getX() + moveDirection.getX());
            this.point.setY(this.point.getY() + moveDirection.getY());
            this.radius = calculateRadius();
        }

        @Override
        public void resize(double resizeFactor) {
            this.point.setX(this.point.getX()*resizeFactor);
            this.point.setY(this.point.getY()*resizeFactor);
            this.radius = calculateRadius();
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(new Point2D(1, 1), new Point2D(1, 5));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
