package designpattern;

public class GetInstanceOfSingletonUsingHolder {
    public static void main(String[] args) {
        Singleton singleton = Singleton.Holder.INSTANCE;
        Singleton singleton1 = Singleton.Holder.INSTANCE;
        System.out.println(singleton.hashCode() + " -----> " + singleton1.hashCode());
    }
}
