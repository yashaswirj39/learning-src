package MultiThreading.producerconsumer.database;

import MultiThreading.producerconsumer.database.table.index.CustomTimerTask;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        DatabaseInfo dbCon = new DatabaseInfo();
        //dbCon.setUserName("cxpsadm_yashaswi_48dev");
        dbCon.setUserName("cxpsadm_yashaswi_51dfc");
        dbCon.setPassword("c_xps123");
        dbCon.setDbType("sqlserver");
        dbCon.setIp("192.168.5.76");
        dbCon.setPort("1433");
        dbCon.setSid("CXPSWINSQL");
        /*dbCon.setUserName("cxpsadm_yashaswiD11_48yes");
        dbCon.setPassword("C_xps123");
        dbCon.setDbType("oracle");
        dbCon.setIp("192.168.5.70");
        dbCon.setPort("1521");
        dbCon.setSid("db12c");*/
        DatabaseConnection connection = new DatabaseConnection();
        return connection.establishConnection(dbCon);
    }

    public void insertRecords() throws SQLException, ClassNotFoundException {
        int counter = 0;
        try (Connection con = getConnection()) {
            System.out.println("connection established" + con);
            for (int i = 44222; i < 90000; i++) {
                try (PreparedStatement ps =
                             con.prepareStatement("INSERT INTO TEST (ID, NAME, fDate) VALUES (?,?,GETDATE() + " + i + ")")) {
                    ps.setString(1, "ID - " + i);
                    ps.setString(2, "name-" + i);
                    ps.setString(3, "nic-" + counter);
                    ps.setString(4, "name-" + counter);
                    ps.setString(5, "C_F_000000" + counter);

                    counter++;
                    if (counter >= 10000) {
                        System.out.println("Inserted record " + i);
                        counter = 0;
                    }
                    ps.executeUpdate();
                }
            }
        }
    }

    private void insertRecordsInsideCtr_Ntr(Map<String, String> map) {
        String sql = "Insert into CTR_NTR_REPORT (REPORT_KEY,REPORT_TYPE,MONTH,YEAR,CONTENT,CREATED_ON,UPDATED_ON,RVN,SOURCE,ERROR,CREATION_DATE)\n" +
                "values (?,?,?,?,?,?,?,?,?,?,?)";
        List<String> keysArray = new ArrayList<>(map.keySet());
        try (Connection connection = getConnection()) {
            for (int i = 0; i < map.size(); i++) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    System.out.println("counter: " +i);
                    ps.setString(1, keysArray.get(i));
                    ps.setString(2, "LCTR");
                    ps.setString(3, "9");
                    ps.setString(4, "2019");
                    ps.setString(5, "");
                    ps.setTimestamp(6, Timestamp.valueOf(map.get(keysArray.get(i)) + " 00:00:00"));
                    ps.setTimestamp(7, Timestamp.valueOf(map.get(keysArray.get(i)) + " 00:00:00"));
                    ps.setInt(8, 0);
                    ps.setString(9, "T");
                    ps.setString(10, "OK");
                    ps.setTimestamp(11, Timestamp.valueOf(map.get(keysArray.get(i)) + " 00:00:00"));
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> selectRecords() {
        Map<String, String> map = new HashMap<>();
        try (Connection con = getConnection()) {
            System.out.println("connection established" + con);
            try (PreparedStatement ps =
                         con.prepareStatement("select * from CBS_TRAN_DATA")) {
                try (ResultSet rs = ps.executeQuery()) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int count = rsmd.getColumnCount();
                    for (int i = 1; i <= count; i++) {
                        LCTRLoader lctrLoader = new LCTRLoader();
                        /*System.out.println(rsmd.getColumnName(i));
                        System.out.println(rsmd.getColumnTypeName(i));*/
                        if (rsmd.getColumnTypeName(i).equalsIgnoreCase("varchar")) {
                            String dtr = "lctrLoader" + ".set" + rsmd.getColumnName(i).substring(0, 1).toUpperCase() +
                                    rsmd.getColumnName(i).substring(1) + "(rs.getString(" +'"'+ rsmd.getColumnName(i) + '"' +"));";
                            System.out.println("String: " + dtr);
                        } else if (rsmd.getColumnTypeName(i).equalsIgnoreCase("date")) {
                            String dtr = "lctrLoader" + ".set" + rsmd.getColumnName(i).substring(0, 1).toUpperCase() +
                                    rsmd.getColumnName(i).substring(1) +"(rs.getDate(" + '"' + rsmd.getColumnName(i) + '"' + "));";
                            System.out.println("Date: " + dtr);
                        } else if (rsmd.getColumnTypeName(i).equalsIgnoreCase("decimal")) {
                            String dtr = "lctrLoader" + ".set" + rsmd.getColumnName(i).substring(0, 1).toUpperCase() +
                                    rsmd.getColumnName(i).substring(1) + "(rs.getDecimal(" + '"' + rsmd.getColumnName(i) + '"' +"));";
                            System.out.println("Decimal: " + dtr);
                        }
                    }
                    /*while (rs.next()) {
                        map.put("LCTR-" + rs.getString("tran_id")
                                , String.valueOf(rs.getDate("tran_date")));
                    }*/
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(map);
        System.out.println(map.size());
        return map;
    }

    private void selectRecordsOnFetch(Map<String, String> map) {
        Map<String, List<String>> resultMap = new HashMap<>();
        List<String> list = new ArrayList<>(map.keySet());
        System.out.println(list);
        try (Connection con = getConnection()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("counter: " + i);
                try (PreparedStatement ps =
                             con.prepareStatement("select * from CBS_TRAN_DATA WHERE tran_id = ? and tran_date = ?")) {
                    String td = list.get(i).replaceAll("LCTR-", "");
                    System.out.println(td + " ---> " + map.get(list.get(i)));
                ps.setString(1, td);
                ps.setString(2, map.get(list.get(i)));
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String tran_id = rs.getString("tran_id");
                        System.out.println(tran_id);
                        String tran_date = rs.getString("tran_date");
                        System.out.println(tran_date);
                        String channel = rs.getString("channel");
                        System.out.println(channel);
                        String key = tran_id + tran_date;
                        System.out.println(key);
                        if (!resultMap.containsKey(key)) {
                            List<String> value = new ArrayList<>();
                            value.add(channel);
                            resultMap.put(key, value);
                        } else {
                            List<String> value = resultMap.get(key);
                            value.add(channel);
                            resultMap.put(key, value);
                        }
                    }
                }
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("rm -----> " + resultMap);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Test t = new Test();
        System.out.println(t.getConnection());
        Map<String, String> map = t.selectRecords();
        //t.selectRecordsOnFetch(map);
        //t.insertRecordsInsideCtr_Ntr(map);
        //System.out.println(t.checkTablePresence("ABC"));
    }
    /*public List<ResultSet> getResultSetList(List<PreparedStatement> psList) throws SQLException {
        int counter = 0;
        List<ResultSet> rsList = new ArrayList<>();
        for(PreparedStatement ps: psList) {
            System.out.println("counter: " + counter++);
            ResultSet rs = ps.executeQuery();
            rsList.add(rs);
        }
        return rsList;
    }*/

    /*public Map<String, List<String>> resultSetToMap(List<ResultSet> resultSets) throws SQLException {
        Map<String,List<String>> map = new HashMap<>();
        for (ResultSet rs : resultSets) {
            while (rs.next()) {
                String tran_id = rs.getString("tran_id");
                System.out.println(tran_id);
                String tran_date = rs.getString("tran_date");
                System.out.println(tran_date);
                String channel = rs.getString("channel");
                System.out.println(channel);
                String key = tran_id + tran_date;
                if (!map.containsKey(key)) {
                    List<String> channelList = new ArrayList<>();
                    channelList.add(channel);
                    map.put(key, channelList);
                } else {
                    List<String> channelList = map.get(key);
                    channelList.add(channel);
                    map.put(key, channelList);
                }
            }
        }
        System.out.println("map final data: " + map);
        System.out.println("map final data size: " + map.size());
        return map;
    }*/
    /*private boolean checkTablePresence(String tableName) {
        boolean flag = false;
        try (Connection connection = getConnection()) {
            DatabaseMetaData meta = connection.getMetaData();
            try(ResultSet res = meta.getTables(null, null, tableName, new String[] {"TABLE"})){
                while (res.next()){
                    System.out.println(res.getString("TABLE_NAME"));
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }*/

    /*protected ArrayList<SchedularRequestFetcher> checkSchedularEntry() {

        ArrayList<SchedularRequestFetcher> schedularList = new ArrayList<>();
        String sql = "select * from CUSTOM_SCHEDULAR_MASTER";
        try (Connection connection = getConnection()) {
            System.out.println(connection);
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        SchedularRequestFetcher schedularRequestFetcher = new SchedularRequestFetcher();
                        schedularRequestFetcher.setId(rs.getString("SCHEDULAR_ID"));
                        schedularRequestFetcher.setName(rs.getString("SCHEDULAR_NAME"));
                        schedularRequestFetcher.setTime(rs.getString("SCHEDULAR_TIMING"));
                        System.out.println(rs.getTimestamp("SCHEDULAR_TIMING"));
                        schedularRequestFetcher.setFrequence(rs.getString("SCHEDULAR_FREQUENCY"));
                        schedularRequestFetcher.setTableName(rs.getString("SCHEDULAR_TABLE"));
                        schedularRequestFetcher.setColumnName(rs.getString("SCHEDULAR_COLUMN"));
                        schedularRequestFetcher.setFromDate(rs.getDate("SCHEDULAR_FROM_DATE"));
                        schedularRequestFetcher.setToDate(rs.getDate("SCHEDULAR_TO_DATE"));
                        schedularRequestFetcher.setCreated_on(rs.getTimestamp("CREATED_ON"));
                        schedularRequestFetcher.setUpdated_on(rs.getTimestamp("UPDATED_ON"));
                        schedularList.add(schedularRequestFetcher);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return schedularList;
    }

    public void printSchedularList() throws InterruptedException {
        ArrayList<SchedularRequestFetcher> list = checkSchedularEntry();

        ConcurrentHashMap<String, SubmitRequestFetcher> chm = new ConcurrentHashMap<>();

        for (SchedularRequestFetcher schedularRequestFetcher : list) {
            //System.out.println(Timestamp.valueOf(schedularRequestFetcher.getTime()).getTime());
            //chm.put(schedularRequestFetcher.getId());
            System.out.println(schedularRequestFetcher.getId());
            System.out.println(schedularRequestFetcher.getName());
            System.out.println(schedularRequestFetcher.getTime());
            System.out.println(schedularRequestFetcher.getFrequence());
            System.out.println(schedularRequestFetcher.getTableName());
            System.out.println(schedularRequestFetcher.getColumnName());
            System.out.println(schedularRequestFetcher.getFromDate());
            System.out.println(schedularRequestFetcher.getToDate());
            System.out.println("created ----> "+schedularRequestFetcher.getCreated_on());
            System.out.println("updated ----> " +schedularRequestFetcher.getUpdated_on());
            System.out.println("-----------------------------------------------");
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                printSchedularList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test executorDaemon = new Test();
        ExecutorService schedulerExecutor = Executors.newSingleThreadExecutor();
        schedulerExecutor.execute(executorDaemon);
        System.out.println("------------------------------------------");
        schedulerExecutor.shutdown();
        schedulerExecutor.awaitTermination(10, TimeUnit.SECONDS);

        *//*System.out.println(Timestamp.valueOf(LocalDate.now() + " 02:30:31").getTime());*//*
     *//*System.out.println(Timestamp.valueOf("2019-10-14 02:44:44").getTime());*//*
    }*/
}
