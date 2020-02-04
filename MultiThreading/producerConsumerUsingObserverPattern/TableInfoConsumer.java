package MultiThreading.producerConsumerUsingObserverPattern;

import MultiThreading.producerconsumer.database.DatabaseConnection;
import MultiThreading.producerconsumer.database.DatabaseInfo;
import MultiThreading.producerconsumer.database.table.index.TableInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TableInfoConsumer implements ConsumerObserver, Runnable {

    private ProducerSubject subject;
    private BlockingQueue<String> tableInfoConsumerQueue = new LinkedBlockingQueue<>();

    public TableInfoConsumer(Producer subject) {
        this.subject = subject;
        subject.registerConsumer(this);
    }

    @Override
    public void update(ProducerSubject subject) {
        if (subject instanceof Producer) {
            Producer producer = (Producer) subject;
            this.tableInfoConsumerQueue = producer.getProducerQueue();
            tableInfoConsumerQueue.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (tableInfoConsumerQueue) {
                while (tableInfoConsumerQueue.isEmpty()) {
                    try {
                        System.out.println("TableInfoConsumer Queue is Empty...... hence moved to wait state for 10 seconds --> " + Thread.currentThread().getName());
                        tableInfoConsumerQueue.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //System.out.println("Table info consumer called... queue size and data ---> " + tableInfoConsumerQueue);
                String username = tableInfoConsumerQueue.poll();
                LinkedHashMap<String, TableInfo> tableInfoMap = tableInfo(username);
                tableInfoMap.forEach((k, v) -> {
                    System.out.println(Thread.currentThread().getName() + "----> Username from TableInfo -----> " + k);
                    System.out.println("TableName --> " + v.getTableName());
                    System.out.println("Schema Name --> " + v.getSchemaName());
                    System.out.println("Row Counts --> " + v.getRowCounts());
                    System.out.println("Total space KB --> " + v.getTotalSpaceKB());
                    System.out.println("Total space MB --> " + v.getTotalSpaceMB());
                    System.out.println("Used space KB --> " + v.getUsedSpaceKB());
                    System.out.println("Used space MB --> " + v.getUsedSpaceMB());
                    System.out.println("Unused space KB --> " + v.getUnUsedSpaceKB());
                    System.out.println("Unused space MB --> " + v.getUnUsedSpaceMB());
                });
            }
        }
    }

    public Connection getConnection(String username) throws SQLException, ClassNotFoundException {
        DatabaseConnection dbc = new DatabaseConnection();
        DatabaseInfo dbinfo = dbc.setDBDetails(username, "c_xps123", "sqlserver", "192.168.5.76", "1433", "CXPSWINSQL");
        return dbc.establishConnection(dbinfo);
    }

    private String sql() {
        return "SELECT \n" +
                "    t.NAME AS TableName,\n" +
                "    s.Name AS SchemaName,\n" +
                "    p.rows AS RowCounts,\n" +
                "    SUM(a.total_pages) * 8 AS TotalSpaceKB, \n" +
                "    CAST(ROUND(((SUM(a.total_pages) * 8) / 1024.00), 2) AS NUMERIC(36, 2)) AS TotalSpaceMB,\n" +
                "    SUM(a.used_pages) * 8 AS UsedSpaceKB, \n" +
                "    CAST(ROUND(((SUM(a.used_pages) * 8) / 1024.00), 2) AS NUMERIC(36, 2)) AS UsedSpaceMB, \n" +
                "    (SUM(a.total_pages) - SUM(a.used_pages)) * 8 AS UnusedSpaceKB,\n" +
                "    CAST(ROUND(((SUM(a.total_pages) - SUM(a.used_pages)) * 8) / 1024.00, 2) AS NUMERIC(36, 2)) AS UnusedSpaceMB\n" +
                "FROM \n" +
                "    sys.tables t\n" +
                "INNER JOIN      \n" +
                "    sys.indexes i ON t.OBJECT_ID = i.object_id\n" +
                "INNER JOIN \n" +
                "    sys.partitions p ON i.object_id = p.OBJECT_ID AND i.index_id = p.index_id\n" +
                "INNER JOIN \n" +
                "    sys.allocation_units a ON p.partition_id = a.container_id\n" +
                "LEFT OUTER JOIN \n" +
                "    sys.schemas s ON t.schema_id = s.schema_id\n" +
                "WHERE \n" +
                "    t.NAME NOT LIKE 'dt%' \n" +
                "    AND t.is_ms_shipped = 0\n" +
                "    AND i.OBJECT_ID > 255 \n" +
                "GROUP BY \n" +
                "    t.Name, s.Name, p.Rows\n" +
                "ORDER BY \n" +
                "    t.Name";
    }

    private LinkedHashMap<String, TableInfo> tableInfo(String userName) {
        LinkedHashMap<String, TableInfo> tableInfoMap = new LinkedHashMap<>();

        try (Connection connection = (Connection) getConnection(userName)) {
            try (PreparedStatement ps = connection.prepareStatement(sql())) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        TableInfo tableInfo = new TableInfo();
                        tableInfo.setTableName(rs.getString("TableName"));
                        tableInfo.setSchemaName(rs.getString("SchemaName"));
                        tableInfo.setRowCounts(rs.getString("RowCounts"));
                        tableInfo.setTotalSpaceKB(rs.getString("TotalSpaceKB"));
                        tableInfo.setTotalSpaceMB(rs.getString("TotalSpaceMB"));
                        tableInfo.setUsedSpaceKB(rs.getString("UsedSpaceKB"));
                        tableInfo.setUsedSpaceMB(rs.getString("UsedSpaceMB"));
                        tableInfo.setUnUsedSpaceKB(rs.getString("UnusedSpaceKB"));
                        tableInfo.setUnUsedSpaceMB(rs.getString("UnusedSpaceMB"));
                        tableInfoMap.put(userName, tableInfo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tableInfoMap;
    }
}