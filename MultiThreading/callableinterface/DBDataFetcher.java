package MultiThreading.callableinterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DBDataFetcher {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://192.168.5.76:1433",
                "cxpsadm_rashmi_48dev", "c_xps123");*/

        /*Queue<String> queue = new ArrayBlockingQueue<>(2);
        queue.add("abc");
        queue.add("def");

        System.out.println(queue.size());

        queue.poll();
        queue.poll();
        System.out.println(queue);*/

        System.out.println(Math.ceil(2.34));
    }
}
