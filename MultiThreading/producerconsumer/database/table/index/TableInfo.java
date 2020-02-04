package MultiThreading.producerconsumer.database.table.index;

public class TableInfo {
    private String tableName;
    private String schemaName;
    private String rowCounts;
    private String totalSpaceKB;
    private String totalSpaceMB;
    private String usedSpaceKB;
    private String usedSpaceMB;
    private String unUsedSpaceKB;
    private String unUsedSpaceMB;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getRowCounts() {
        return rowCounts;
    }

    public void setRowCounts(String rowCounts) {
        this.rowCounts = rowCounts;
    }

    public String getTotalSpaceKB() {
        return totalSpaceKB;
    }

    public void setTotalSpaceKB(String totalSpaceKB) {
        this.totalSpaceKB = totalSpaceKB;
    }

    public String getTotalSpaceMB() {
        return totalSpaceMB;
    }

    public void setTotalSpaceMB(String totalSpaceMB) {
        this.totalSpaceMB = totalSpaceMB;
    }

    public String getUsedSpaceKB() {
        return usedSpaceKB;
    }

    public void setUsedSpaceKB(String usedSpaceKB) {
        this.usedSpaceKB = usedSpaceKB;
    }

    public String getUsedSpaceMB() {
        return usedSpaceMB;
    }

    public void setUsedSpaceMB(String usedSpaceMB) {
        this.usedSpaceMB = usedSpaceMB;
    }

    public String getUnUsedSpaceKB() {
        return unUsedSpaceKB;
    }

    public void setUnUsedSpaceKB(String unUsedSpaceKB) {
        this.unUsedSpaceKB = unUsedSpaceKB;
    }

    public String getUnUsedSpaceMB() {
        return unUsedSpaceMB;
    }

    public void setUnUsedSpaceMB(String unUsedSpaceMB) {
        this.unUsedSpaceMB = unUsedSpaceMB;
    }
}
