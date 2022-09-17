package com.github.rshtishi;

public class Exercise11 {

    static interface Resizable {

        public void resize(double resizeFactor);
    }

    public static void main(String[] args) {

        Exercise9.Circle circle = new Exercise9.Circle(new Exercise9.Point2D(1, 1), new Exercise9.Point2D(1, 5));
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

        circle.resize(2);
        System.out.println(circle.getRadius());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

    }
}
