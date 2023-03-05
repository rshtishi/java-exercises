package com.github.rshtishi;

public class Exercise9Test {

    public static class MoveDirection {
        private double dx;
        private double dy;

        public MoveDirection(double dx, double dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public double getDx() {
            return dx;
        }

        public double getDy() {
            return dy;
        }
    }

    public static interface Resizable{
        void resize(double resizeFactor);
    }

    public static interface Movable {
        void move(MoveDirection direction);
    }

    public static class Point2D implements Movable {
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
        public void move(MoveDirection direction) {
            x = x + direction.getDx();
            y = y + direction.getDy();
        }

        @Override
        public String toString() {
            return String.format("Point2D{x:%f,y:%f}", x, y);
        }
    }

    public static class Circle implements Movable, Resizable {

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

        @Override
        public void move(MoveDirection direction) {
            this.center.move(direction);
            this.point.move(direction);
        }

        @Override
        public String toString() {
            return String.format("Circle{center:%s,point:%s}", center.toString(), point.toString());
        }

        @Override
        public void resize(double resizeFactor) {
            double dx=(point.getX()*resizeFactor)-point.getX();
            double dy=(point.getY()*resizeFactor)-point.getY();
            MoveDirection direction = new MoveDirection(dx,dy);
            point.move(direction);
        }
    }



    public static void main(String[] args) {

        Circle circle = new Circle(new Point2D(0, 0), new Point2D(4, 0));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle);
        circle.move(new MoveDirection(2, 2));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle);
        System.out.println(circle.getRadius());
        circle.resize(0.5);
        System.out.println(circle);
        System.out.println(circle.getRadius());
    }
}
