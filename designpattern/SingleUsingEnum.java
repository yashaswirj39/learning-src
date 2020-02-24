package designpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum SingleUsingEnum {
    INSTANCE;

    public String getConfiguration() {
        return "configuration...";
    }
}

class TestClass {
    static void useSingleton() {
        SingleUsingEnum singleUsingEnum = SingleUsingEnum.INSTANCE;
        System.out.println("singleton: " + singleUsingEnum.hashCode());
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(TestClass::useSingleton);
        service.submit(TestClass::useSingleton);
        service.shutdown();
    }
}