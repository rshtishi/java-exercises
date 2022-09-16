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

    static class Circle {

        public static final double PI = 3.14;

        private Point2D center;
        private Point2D point;

        Circle(Point2D center, Point2D point) {
            this.center = center;
            this.point = point;
        }

        public double getRadius(){
            return Math.sqrt(Math.pow(center.getX()-point.getX(),2)+Math.pow(center.getY()-point.getY(),2))/2;
        }

        public double getPerimeter(){
            return 2*PI*getRadius();
        }

        public double getArea(){
            return PI*Math.pow(getRadius(),2);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(new Point2D(1,1),new Point2D(1,5));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
