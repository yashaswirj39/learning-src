package sat;

public class MethodOverloading {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.m1(1);
        animal.m1(1,3.0f);
        //animal.m3(3);
    }
}
class Animal{
    public void m1(int i) {
        System.out.println("m1 --> " + i);
    }

    public void m1(int i, float j){
        System.out.println("m2 ---> "+(i+j));
    }

    /**
     * Method with same name and same argument is defined more than once
     * so can't be overloaded.
     * @param var
     */
    /*public void m1(int var){
        System.out.println("m3 ---> "+ var);
    }*/
}