package com.github.rshtishi;

import java.util.List;
import java.util.Objects;

public class Exercise18 {

    public static class Computer {

        private String processor;
        private String ram;
        private List<String> graphicCards;
        private String company;
        private String model;


        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public String getRam() {
            return ram;
        }

        public void setRam(String ram) {
            this.ram = ram;
        }

        public List<String> getGraphicCards() {
            return graphicCards;
        }

        public void setGraphicCards(List<String> graphicCards) {
            this.graphicCards = graphicCards;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Computer computer = (Computer) o;

            if (processor != null ? !processor.equals(computer.processor) : computer.processor != null) return false;
            if (ram != null ? !ram.equals(computer.ram) : computer.ram != null) return false;
            if (graphicCards != null ? !graphicCards.equals(computer.graphicCards) : computer.graphicCards != null)
                return false;
            if (company != null ? !company.equals(computer.company) : computer.company != null) return false;
            return model != null ? model.equals(computer.model) : computer.model == null;
        }

        @Override
        public int hashCode() {
            return Objects.hash(processor, ram, graphicCards, company, model);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Computer{");
            sb.append("processor='").append(processor).append('\'');
            sb.append(", ram='").append(ram).append('\'');
            sb.append(", graphicCards=").append(graphicCards);
            sb.append(", company='").append(company).append('\'');
            sb.append(", model='").append(model).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args){

        Computer computer = new Computer();
        Computer computer2 = new Computer();
        System.out.println(computer2.equals(computer));
        System.out.println(computer2.hashCode());
        System.out.println(computer.hashCode());
    }
}
