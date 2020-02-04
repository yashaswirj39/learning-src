package MultiThreading.callableinterface;

import java.util.concurrent.Callable;

public class AdderCallable implements Callable<Integer> {
    int count = 0;

    public int doAdd() {
        count = count + 1;
        System.out.println("Counter ----> " + count);
        return count;
    }

    @Override
    public Integer call() throws Exception {
        return doAdd();
    }
}
