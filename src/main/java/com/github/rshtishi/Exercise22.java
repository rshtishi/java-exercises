package com.github.rshtishi;

public class Exercise22 {

    public static interface Fillable {
         public void fill(int num);
    }

    public static void main(String[] args){

        Exercise21.Cube cube = new Exercise21.Cube(5);
        cube.fill(500);

        Exercise21.Cone cone = new Exercise21.Cone(5,8,6);
        cone.fill(150);
    }
}
