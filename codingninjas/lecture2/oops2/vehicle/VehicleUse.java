package codingninjas.lecture2.oops2.vehicle;

public class VehicleUse {
    public static void main(String[] args) {
        /*Vehicle v = new Vehicle();
        v.color = "balck";
        v.setMaxSpeed(100);*/
        //v.print();

        /**
         * type casting is required if we want to access object of super class from subclass.
         */
        Car c = (Car) new Vehicle(20);


        Car car = new Car(10, 20);
        car.numGears = 10;
        car.color = "black";
        car.setMaxSpeed(500);
        //car.printCar();
    }
}
