package designpattern;

public class TestObjectCloneForSingleton{
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1: " + s1 + " hashcode: " + s1.hashCode());
        System.out.println("s2: " + s2 + " hashcode: " + s2.hashCode());
        Singleton s3 = (Singleton) s2.clone();
        System.out.println("s3: " + s3 + " hashcode: " + s3.hashCode());
    }
}
