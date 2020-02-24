import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InboxCluster {
    private static String convertFileToString() throws IOException {
        return new String(Files.readAllBytes(Paths.get("/home/yashaswi/Desktop/BOC/inbox/Inbox_Fix/inbox-cluster-clari5.conf")));
    }

    private static void createInboxGroupAndCluster(String inboxData) {

    }

    /*private static String convertStringToJson(String string) {

    }*/

    public static void main(String[] args) throws IOException {
        createInboxGroupAndCluster(convertFileToString());
    }
}
