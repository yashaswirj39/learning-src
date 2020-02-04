package MultiThreading.producerconsumer.consumer.factory;

import MultiThreading.producerconsumer.database.DatabaseConnection;
import MultiThreading.producerconsumer.database.DatabaseInfo;
import MultiThreading.producerconsumer.database.table.index.IndexInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DataConsumer implements Runnable {

    int count = 0;
    Connection connection;
    public Queue<String> queue;

    public DataConsumer(Queue<String> queue) {
        this.queue = queue;
    }

    public Connection getConnection(String username) throws SQLException, ClassNotFoundException {
        DatabaseConnection dbc = new DatabaseConnection();
        DatabaseInfo dbinfo = dbc.setDBDetails(username, "c_xps123", "sqlserver", "192.168.5.76", "1433", "CXPSWINSQL");
        return dbc.establishConnection(dbinfo);
    }

    /*public String selectSqlQuery(List<String> parametersList, String tableName){
        StringBuilder sb = new StringBuilder("");
        parametersList.forEach((users) -> sb.append("'").append(users).append("',"));
        sb.replace(sb.lastIndexOf(","), sb.length(), "");
        return "SELECT " + sb.toString() + " FROM " + tableName;
    }*/

    public List<IndexInfo> indexInfo(String username) {
        List<IndexInfo> indexInfoList = new ArrayList<>();
        try (PreparedStatement ps = getConnection(username).prepareStatement("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    IndexInfo info = new IndexInfo();

                    info.setUser(username);
                    info.setTable(rs.getString("TABLE_NAME"));
                    System.out.println("Tables from database ---> " + rs.getString("TABLE_NAME"));

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

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Consumer Queue is Empty...... hence moved to wait state for 30 seconds --> "+Thread.currentThread().getName());
                        queue.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String username = queue.poll();
                System.out.println("queue size in consumer: --> " + queue.size());
                List<IndexInfo> indexInfoList = indexInfo(username);
                for (IndexInfo info : indexInfoList) {
                    System.out.println(++count + ". User name --> " + info.getUser());
                    System.out.println(count + ". Table name --> " + info.getTable());
                    System.out.println(count + ". Index Map  --> " + info.getTableIndexInfo());
                }
                System.out.println("In last" + queue);
                queue.notify();
            }
        }
    }
}
