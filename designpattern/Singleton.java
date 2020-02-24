package designpattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton implements Serializable, Cloneable{
    private static volatile Singleton soleInstance = null;

    static class Holder {
        static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {

        /**
         * Using reflection an instance acan be created for singleton classes.
         * By involing constructor class and setting setaccessible(true).
         * To avoid that, we have to provide a check, and throw an runtime exception,
         * saying instance creation ar available only with getInstance() method.
         */
        if (soleInstance != null)
            throw new RuntimeException("Cannot create new instance. The instance is already available." +
                    "Please use getInstance() method to access the instance");
        System.out.println("Creating...");
    }

    /**
     * we can create using inner class;
     * inner class is Holder class here.
     * @return
     */
    public static Singleton getInstanceFromHolder() {
        return Holder.INSTANCE;
    }

    public static Singleton getInstance() {
        /**
         * Double check locking for multithreaded example
         */
        if (soleInstance == null) {
            synchronized (Singleton.class) {
                if (soleInstance == null) {
                    soleInstance = new Singleton();
                }
            }
        }
        return soleInstance;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("..read Resolve");
        return soleInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        if (soleInstance != null) {
            throw new RuntimeException("Cloning not allowed...");
        }
        return super.clone();
    }
}

class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

        /**
         * Test case for reflection API:
         */

        /**
         * here it will allow reflection to create instance of Singleton class
         * becaue when main will excute the first excution point will come to
         * reflection mentioned below and at this particular time no instances are
         * available so private constructor will allow the reflection api to create an instance of
         * singleton class.
         */
        Class clazz = Class.forName("designpattern.Singleton");
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s3 = constructor.newInstance();
        System.out.println("s3: " + s3 + " hashcode: " + s3.hashCode());

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1: " + s1 + " hashcode: " + s1.hashCode());
        System.out.println("s2: " + s2 + " hashcode: " + s2.hashCode());

        /**
         * The below line will throw exception because, the is created already
         * after that we are trying to create instance of singleton class
         * by invoking reflection api.
         */
        Class clazz1 = Class.forName("designpattern.Singleton");
        Constructor<Singleton> constructor1 = clazz1.getDeclaredConstructor();
        constructor1.setAccessible(true);
        Singleton s4 = constructor.newInstance();
        System.out.println("s4: " + s4 + " hashcode: " + s4.hashCode());
    }
}
