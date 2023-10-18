package oop;

public class Bus {
    private int number;
    private String model;
    private Passenger[] passengers;
    private int passengersCount;
    private Driver driver;
    private boolean isOnRoad;


    public Bus(int number, String model) {
        this.number = number;
        this.model = model;
        this.passengers = new Passenger[3];
        this.passengersCount = 0;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void go() {
        this.isOnRoad = true;
        System.out.println("Bus # " + this.number + " are driven by " + driver.getName());
        System.out.println("Passengers: ");
        for (int i = 0; i < passengersCount; i++) {
            System.out.println(passengers[i].getName());
        }
    }

    public void income(Passenger passenger) {
        String message = null;
        if (isOnRoad) {
            message = "Bus is running";
        }
        if (this.passengersCount == this.passengers.length){
            message = "Bus is full";
        }
        if (message != null){
            System.err.println(message);
            return;
        }
        this.passengers[passengersCount] = passenger;
        this.passengersCount++;
    }
}
