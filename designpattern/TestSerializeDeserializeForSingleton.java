package designpattern;

import java.io.*;

public class TestSerializeDeserializeForSingleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * Test Case for Serialization and de-serialization case in singleton instance
         */

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1: " + s1 + " hashcode: " + s1.hashCode());
        System.out.println("s2: " + s2 + " hashcode: " + s2.hashCode());

        //Serialization
        System.out.println("Serializinf and de-serializing...");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("s2.ser"));
        oos.writeObject(s2);
        oos.close();

        //De-Serializing
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("s2.ser"));
        Singleton sd5 = (Singleton) ooi.readObject();
        ooi.close();

        System.out.println("sd5: "+ sd5 + " hascode: "+ sd5.hashCode());
    }
}
