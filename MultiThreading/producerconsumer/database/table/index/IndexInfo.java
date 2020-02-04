package MultiThreading.producerconsumer.database.table.index;

import java.util.LinkedHashMap;

public class IndexInfo {
    private String user;
    private String table;
    private LinkedHashMap<String, String> tableIndexInfo;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public LinkedHashMap<String, String> getTableIndexInfo() {
        return tableIndexInfo;
    }

    public void setTableIndexInfo(LinkedHashMap<String, String> tableIndexInfo) {
        this.tableIndexInfo = tableIndexInfo;
    }
}
