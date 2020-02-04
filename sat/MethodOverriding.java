package sat;

public class MethodOverriding {
    public static void main(String[] args) {
        AnimalOverRide animalOverRide = new AnimalOverRide();
        animalOverRide.m1();

        /**
         * Overriding code result
         */

        AnimalOverRide animalOverRide1 = new DogOverRide();
        animalOverRide1.m1();
    }
}
class AnimalOverRide{
    public void m1(){
        System.out.println("It's SuperClass");
    }
}
class DogOverRide extends AnimalOverRide {
    public void m1(){
        System.out.println("I am extended");
    }
}