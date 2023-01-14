package com.github.rshtishi;

public class Exercise9 {

    static class Point2D implements Exercise10.Moveable {
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

        @Override
        public void move(Exercise10.MoveDirection moveDirection) {
            x += moveDirection.getX();
            y += moveDirection.getY();
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

        private double calculateRadius() {
            double xVal = Math.pow(center.getX() - point.getX(), 2);
            double yVal = Math.pow(center.getY() - point.getY(), 2);
            double sum = xVal + yVal;
            return Math.sqrt(sum);
        }

        public double getRadius() {
            return radius;
        }

        public double getPerimeter() {
            return 2 * PI * radius;
        }

        public double getArea() {
            return PI * Math.pow(radius, 2);
        }

        @Override
        public void move(Exercise10.MoveDirection moveDirection) {
            this.center.move(moveDirection);
            this.point.move(moveDirection);
        }

        @Override
        public void resize(double resizeFactor) {
            double dx = this.point.getX() * resizeFactor - this.point.getX();
            double dy = this.point.getY() * resizeFactor - this.point.getY();
            Exercise10.MoveDirection direction = new Exercise10.MoveDirection(dx, dy);
            this.point.move(direction);
            this.radius = calculateRadius();
        }

        public void setPoint(Point2D point) {
            this.point = point;
            this.radius = calculateRadius();
        }

        public void setCenter(Point2D center) {
            this.center = center;
            this.radius = calculateRadius();
        }
    }

    public static void main(String[] args) {
        Point2D center = new Point2D(1, 1);
        Point2D point = new Point2D(1, 5);
        Circle circle = new Circle(center, point);
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
