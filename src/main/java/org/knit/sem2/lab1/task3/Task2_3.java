package org.knit.sem2.lab1.task3;

public class Task2_3 {
    public static void main(String[] args) {
        try {
            Transport transport1 = TransportFactory.createTransport("business");
            System.out.println(transport1.getSpecifications());

            Transport transport2 = TransportFactory.createTransport("family");
            System.out.println(transport2.getSpecifications());

            Transport transport3 = TransportFactory.createTransport("delivery");
            System.out.println(transport3.getSpecifications());

            Transport transport4 = TransportFactory.createTransport("sd");
            System.out.println(transport4.getSpecifications());

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}


