package com.github.rshtishi;

import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise7 {

    static class Weapon {

        private Deque<String> magazine;
        private int capacity;

        public Weapon(int capacity) {
            this.capacity = capacity;
            magazine = new ArrayDeque<>();
        }

        public void loadBullet(String bullet) {
            if (magazine.size() == capacity) {
                throw new IllegalStateException("Magazine is full");
            }
            magazine.push(bullet);
        }

        public boolean isLoaded() {
            return magazine.isEmpty();
        }

        public void shot(){
            if(magazine.isEmpty()){
                System.out.println("empty magazine");
                return;
            }
            System.out.println(magazine.pop());
        }
    }

    public static void main(String[] args) {

        Weapon weapon = new Weapon(10);
        weapon.loadBullet("9mm A");
        weapon.loadBullet("9mm b");
        weapon.loadBullet("9mm c");
        weapon.loadBullet("9mm d");

        System.out.println(weapon.isLoaded());

        weapon.shot();
        weapon.shot();
        weapon.shot();
        weapon.shot();
        weapon.shot();
        weapon.shot();

    }
}
