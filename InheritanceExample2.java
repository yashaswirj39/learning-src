public class InheritanceExample2 {

    int age;
    String name;

    public InheritanceExample2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void m1() {
        System.out.println("parent");
    }
    public static void main(String[] args) {
        Child child = new Child(140, "name");
        child.m1();

        InheritanceExample2 ie2 = new Child(20, "name");
        ie2.m1();
    }
}
class Child extends InheritanceExample2 {
    int age;
    String name;

    public Child(int age, String name) {
        super(age, name);
        this.age = age;
        this.name = name;
    }

    public void m1() {
        System.out.println("child");
    }
}