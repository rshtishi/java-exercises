package com.github.rshtishi;

public class Exercise10 {

    static class MoveDirection {

        private double x;
        private double y;

        public MoveDirection(double x, double y) {
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

    static interface Moveable {
        void move(MoveDirection moveDirection);
    }


    public static void main(String[] args) {
        Exercise9.Circle circle = new Exercise9.Circle(new Exercise9.Point2D(1, 1), new Exercise9.Point2D(1, 5));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

        circle.move(new MoveDirection(4,10));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
