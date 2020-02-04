package MultiThreading.producerconsumer.database;

import java.sql.*;

public class DatabaseConnection {

    Connection connection;

    public DatabaseInfo setDBDetails(String username, String pswd, String dbType, String ip, String port, String sid) throws ClassNotFoundException, SQLException {
        DatabaseInfo dbInfo = new DatabaseInfo();
        dbInfo.setDbType(dbType);
        dbInfo.setUserName(username);
        dbInfo.setPassword(pswd);
        dbInfo.setIp(ip);
        dbInfo.setPort(port);
        dbInfo.setSid(sid);
        return dbInfo;
    }

    public Connection establishConnection(DatabaseInfo dbInfo) throws ClassNotFoundException, SQLException {
        switch (dbInfo.getDbType()) {
            case "oracle":
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@" + dbInfo.getIp() + ":" + dbInfo.getPort() + ":" + dbInfo.getSid(), dbInfo.getUserName()
                        , dbInfo.getPassword());
                break;
            case "sqlserver":
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection("jdbc:sqlserver://" + dbInfo.getIp() + ":" + dbInfo.getPort(),
                        dbInfo.getUserName(), dbInfo.getPassword());
        }
        return connection;
    }
}