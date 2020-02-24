package collectiontreemapimplementation;

public class Department {
    private Integer deptId;
    private String deptName;
    private String deptLocation;

    public Department(Integer deptId, String deptName, String deptLocation) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }

    @Override
    public String toString() {
        return "Department {deptId="+deptId+", depName="+deptName+", deptLocation="+deptLocation;
    }
}
