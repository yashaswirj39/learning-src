package MultiThreading.producerConsumerUsingObserverPattern;

import MultiThreading.producerconsumer.database.DatabaseConnection;
import MultiThreading.producerconsumer.database.DatabaseInfo;
import MultiThreading.producerconsumer.database.table.index.IndexInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements ConsumerObserver, Runnable{

    private ProducerSubject subject;
    private BlockingQueue<String> consumerQueue = new LinkedBlockingQueue<>();

    public Consumer(ProducerSubject subject) {
        this.subject = subject;
        subject.registerConsumer(this);
    }

    @Override
    public synchronized void update(ProducerSubject subject) {
        if (subject instanceof Producer){
            Producer producer = (MultiThreading.producerConsumerUsingObserverPattern.Producer) subject;
            this.consumerQueue = producer.getProducerQueue();
            //System.out.println("consumer queue data inside update --> "+consumerQueue);
            consumerQueue.notify();
        }
    }

    @Override
    public void run() {
        while (true){
            synchronized (consumerQueue) {
                //System.out.println("data inside consumer queue ---> "+consumerQueue);
                while (consumerQueue.isEmpty()) {
                    try {
                        System.out.println("Consumer Queue is Empty...... hence moved to wait state for 10 seconds --> "+Thread.currentThread().getName());
                        consumerQueue.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //System.out.println("Consumer called ... queue ----> "+consumerQueue);
                String username = consumerQueue.poll();
                List<IndexInfo> indexInfoList = indexInfo(username);
                for (IndexInfo info : indexInfoList) {
                    System.out.println(Thread.currentThread().getName() + ". User name --> " + info.getUser());
                    System.out.println(Thread.currentThread().getName() + ". Table name --> " + info.getTable());
                    System.out.println(Thread.currentThread().getName() + ". Index Map  --> " + info.getTableIndexInfo());
                }
                //consumerQueue.notify();
            }
        }
    }

    public Connection getConnection(String username) throws SQLException, ClassNotFoundException {
        DatabaseConnection dbc = new DatabaseConnection();
        DatabaseInfo dbinfo = dbc.setDBDetails(username, "c_xps123", "sqlserver", "192.168.5.76", "1433", "CXPSWINSQL");
        return dbc.establishConnection(dbinfo);
    }

    public List<IndexInfo> indexInfo(String username) {
        List<IndexInfo> indexInfoList = new ArrayList<>();
        try (PreparedStatement ps = getConnection(username).prepareStatement("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    IndexInfo info = new IndexInfo();

                    info.setUser(username);
                    info.setTable(rs.getString("TABLE_NAME"));
                    //System.out.println("Tables from database ---> " + rs.getString("TABLE_NAME"));

                    try (PreparedStatement ps1 = getConnection(username).prepareStatement("EXEC sp_helpindex '" + info.getTable() + "'")) {
                        try (ResultSet rs1 = ps1.executeQuery()) {
                            while (rs1.next()) {
                                LinkedHashMap<String, String> tableIndexInfo = new LinkedHashMap<>();
                                tableIndexInfo.put("index_name", rs1.getString("index_name"));
                                tableIndexInfo.put("index_description", rs1.getString("index_description"));
                                tableIndexInfo.put("index_keys", rs1.getString("index_keys"));
                                info.setTableIndexInfo(tableIndexInfo);
                            }
                        } catch (NullPointerException npe) {
                            System.out.println("result set returning null: " + npe.getMessage());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    indexInfoList.add(info);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return indexInfoList;
    }
}
