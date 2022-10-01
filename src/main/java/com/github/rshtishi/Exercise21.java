package com.github.rshtishi;

public class Exercise21 {

    public static abstract class Shape3d extends Exercise20.Shape {

        public abstract double calculateVolume();

    }

    public static class Cone extends Shape3d implements Exercise22.Fillable {

        public static final double PI = 3.14;

        private int height;
        private int slant;
        private int radius;

        public Cone(int height, int slant, int radius) {
            this.height = height;
            this.slant = slant;
            this.radius = radius;
        }

        @Override
        public double calculatePerimeter() {
            return -1;
        }

        @Override
        public double calculateArea() {
            return PI * Math.pow(radius, 2) + PI * radius * slant;
        }

        @Override
        public double calculateVolume() {
            return (PI * Math.pow(radius, 2) * height) / 3;
        }

        @Override
        public void fill(int num) {
            if(num>calculateVolume()){
                System.out.println("not pouring enough water");
            } else if(num==calculateVolume()){
                System.out.println("fill the figure with water to the brim");
            } else {
                System.out.println("will pour too much water into the figure and overflow");
            }
        }
    }

    public static class Cube extends Shape3d implements Exercise22.Fillable {

        private int size;

        public Cube(int size) {
            this.size = size;
        }

        @Override
        public double calculatePerimeter() {
            return 0;
        }

        @Override
        public double calculateArea() {
            return 6 * Math.pow(size, 2);
        }

        @Override
        public double calculateVolume() {
            return Math.pow(size, 3);
        }

        @Override
        public void fill(int num) {
            if(num>calculateVolume()){
                System.out.println("not pouring enough water");
            } else if(num==calculateVolume()){
                System.out.println("fill the figure with water to the brim");
            } else {
                System.out.println("will pour too much water into the figure and overflow");
            }
        }
    }

    public static void main(String[] args) {

        Cone cone = new Cone(5, 5, 2);
        System.out.println(cone.calculateArea());
        System.out.println(cone.calculateVolume());

        Cube cube = new Cube(5);
        System.out.println(cube.calculateArea());
        System.out.print(cube.calculateVolume());

    }
}
