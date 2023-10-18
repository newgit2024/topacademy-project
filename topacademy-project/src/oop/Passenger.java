package oop;

public class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void go(Bus bus){
        bus.income(this);
    }
}
