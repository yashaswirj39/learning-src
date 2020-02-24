package codingninjas.lecture2.oops2.vehicle.vehicle_temp;

import codingninjas.lecture2.oops2.vehicle.Vehicle;

public class Truck extends Vehicle {
    int maxLoadingCapacity;

    public Truck(int maxSpeed, int maxLoadingCapacity) {
        super(maxSpeed);
        this.maxLoadingCapacity = maxLoadingCapacity;
    }

    public void print() {
        System.out.println("Truck Capacity: " + maxLoadingCapacity);
        System.out.println("Truck Color: " + color);
        System.out.println("Truck Maxspeed: "+getMaxSpeed());
    }
}
