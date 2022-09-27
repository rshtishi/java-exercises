package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise19 {

    public static class LapTop extends Exercise18.Computer {

        private String battery;

        public String getBattery() {
            return battery;
        }

        public void setBattery(String battery) {
            this.battery = battery;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            LapTop lapTop = (LapTop) o;

            return battery.equals(lapTop.battery);
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + battery.hashCode();
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("LapTop{");
            sb.append("battery='").append(battery).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        LapTop lapTop = new LapTop();
        lapTop.setBattery("100");
        lapTop.setCompany("DELL");
        lapTop.setProcessor("INTEL");
        lapTop.setGraphicCards(Arrays.asList("INVIDIA"));
        lapTop.setRam("2GB");

        Exercise18.Computer computer = new Exercise18.Computer();
        computer.setCompany("DELL");
        computer.setProcessor("INTEL");
        computer.setRam("2GB");
        computer.setGraphicCards(Arrays.asList("INVIDIA"));

        System.out.println(computer.equals(lapTop));
        System.out.println(lapTop.equals(computer));

    }
}
