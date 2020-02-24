public class InheritanceExample {
    public void abc() {
        System.out.println("parent class...");
    }
    public static void main(String[] args) {
        //At runtime subclass method will be called
        InheritanceExample ie = new Sub();
        ie.abc();

        //At runtime parent method will be called
        InheritanceExample ie1 = new InheritanceExample();
        ie1.abc();

        //At runtime subclass method will be called
        Sub sub = new Sub();
        sub.abc();

        Sub sub1 = (Sub) new InheritanceExample();
        sub1.abc();
    }
}
class Sub extends InheritanceExample {
    public void abc() {
        System.out.println("sub class");
    }
}