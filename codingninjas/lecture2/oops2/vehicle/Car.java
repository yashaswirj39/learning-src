package codingninjas.lecture2.oops2.vehicle;

public class Car extends Vehicle{
    int numGears;
    boolean isConvertible;

    public Car(int numGears, int maxSpeed) {
        super(maxSpeed);
        this.numGears = numGears;
        System.out.println("car constructor");
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void printCar() {
        super.print();
        /*System.out.println("car color: " + color);*/
        /*System.out.println("car maxspeed: " + getMaxSpeed());*/
        System.out.println("car numGears: " + numGears);
        System.out.println("car isConvertiable: " + isConvertible);
    }
}
