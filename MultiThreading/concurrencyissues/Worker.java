package MultiThreading.concurrencyissues;

public class Worker implements Runnable {

    public BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int balance = account.getBalance();
            System.out.println("balance --> " + balance);
            ///synchronized (account) { //provides more flexibility
                account.deposit(10);
            //}
            int endBalance = account.getBalance();
            System.out.println("End balance ---> " + endBalance);
        }
    }
}
