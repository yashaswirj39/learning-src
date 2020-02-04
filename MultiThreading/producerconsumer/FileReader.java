package MultiThreading.producerconsumer;

import MultiThreading.producerconsumer.consumer.factory.DataConsumer;
import MultiThreading.producerconsumer.producer.factory.Dataproducer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> readFile(String filePath) {

        boolean status = false;

        List<String> usersList = new ArrayList<>();

        File file = new File(filePath);
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                try (BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(f)))) {
                    usersList = br.lines().collect(Collectors.toList());
                    System.out.println(usersList);
                    status = true;
                    deleteFile(status, String.valueOf(f));
                } catch (IOException e) {
                    System.out.println("unable to load file: " + e.getMessage());
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return usersList;
    }

    public void deleteFile(boolean status, String path) throws Exception {
        File deleteFileName = new File(path);
        if (status) {
            deleteFileName.delete();
        }
        System.out.println("file deleted successfully...");
    }

    public static void main(String[] args) throws InterruptedException {
        FileReader reader = new FileReader();
        Queue<String> queue = new ArrayBlockingQueue<>(5);
        Dataproducer dp = new Dataproducer(reader, "/home/yashaswi/Desktop/java/multithreading", queue);
        ExecutorService produnceres = Executors.newFixedThreadPool(2);
        produnceres.submit(dp);

        DataConsumer dc = new DataConsumer(queue);
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(2);
        consumerExecutor.submit(dc);

        produnceres.shutdown();
        consumerExecutor.shutdown();
        produnceres.awaitTermination(10, TimeUnit.SECONDS);
        consumerExecutor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
