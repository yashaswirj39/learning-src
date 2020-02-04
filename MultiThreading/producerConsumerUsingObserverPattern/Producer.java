package MultiThreading.producerConsumerUsingObserverPattern;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Producer<T extends Optional> implements ProducerSubject, Runnable {
    List<ConsumerObserver> observersList;
    private BlockingQueue<String> usersList;
    private String queueDirectory;
    private String archiveDirectory;
    private BlockingQueue<String> producerQueue;

    public Producer(String queueDir, String archiveDir) {
        this.observersList = new ArrayList<>();
        this.usersList = new LinkedBlockingDeque<>();
        this.queueDirectory = queueDir;
        this.archiveDirectory = archiveDir;
        this.producerQueue = new LinkedBlockingDeque<>();
    }

    private BlockingQueue<String> fileReader(String queueDir, String archiveDir) {

        if (usersList.isEmpty()) {
            File fileReaderObj = new File(queueDir);

            for (File f : fileReaderObj.listFiles()) {
                if (f.isFile()) {
                    try (BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(f)))) {
                        usersList.addAll(br.lines().collect(Collectors.toCollection(LinkedBlockingQueue::new)));
                        System.out.println(usersList);
                        Files.move(f.toPath(), Paths.get(archiveDir + "/" + f.getName() + System.nanoTime()));
                    } catch (IOException e) {
                        System.out.println("unable to load file: " + e.getMessage());
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    continue;
                }
            }
        } else {
            //System.out.println("userList is not empty...");
        }
        return usersList;
    }

    @Override
    public void registerConsumer(ConsumerObserver co) {
        observersList.add(co);
    }

    @Override
    public void removeConsumer(ConsumerObserver co) {
        observersList.remove(observersList.indexOf(co));
    }

    @Override
    public synchronized void notifyConsumer(BlockingQueue<String> usersList) {
        for (int i = 0; i < observersList.size(); i++) {
            ConsumerObserver consumerObserver = observersList.get(i);
            setProducerQueue(usersList);
            consumerObserver.update(this);
        }
    }

    @Override
    public void reader(String queueDirectory, String archiveDirectory) {
        notifyConsumer(fileReader(queueDirectory, archiveDirectory));
    }

    public BlockingQueue<String> getProducerQueue() {
        return producerQueue;
    }

    public void setProducerQueue(BlockingQueue<String> producerQueue) {
        this.producerQueue = producerQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (usersList) {
                while (usersList.size() == 20) {
                    try {
                        System.out.println("Producer Queue is full...... hence moved to wait state for 10 seconds --> " + Thread.currentThread().getName());
                        usersList.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (usersList.isEmpty()) {
                    try {
                        usersList.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                reader(queueDirectory, archiveDirectory);
                usersList.notify();
               // System.out.println("data inside producer queue --> " + usersList);
            }
        }
    }
}