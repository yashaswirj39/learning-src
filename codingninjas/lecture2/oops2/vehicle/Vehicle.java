package codingninjas.lecture2.oops2.vehicle;

public class Vehicle {
    protected String color;
    private int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        System.out.println("vehicle constructor");
    }


    public Vehicle() {

    }
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("vehicle color: " + color);
        System.out.println("vehicle maxspeed: " + maxSpeed);
    }
}
