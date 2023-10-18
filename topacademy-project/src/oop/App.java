package oop;

import staticjava.A;


public class App {
    public static void main(String[] args) {
        Bus bus = new Bus(46, "Ikarus");
        Driver driver = new Driver("Valera", 33);

        driver.go(bus);

        Passenger passenger1 = new Passenger("Ivan");
        Passenger passenger2 = new Passenger("Olga");
        Passenger passenger3 = new Passenger("Vadim");
        Passenger passenger4 = new Passenger("Rashid");

        passenger1.go(bus);
        passenger2.go(bus);
        passenger3.go(bus);
        passenger4.go(bus);

        driver.drive();

        //new A().f;
    }
}
