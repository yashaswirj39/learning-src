package collectiontreemapimplementation;

public class Employee /*implements Comparable<Employee>*/{
    private int empId;
    private String empName;
    private Double salary;
    private String email;

    public Employee(int empId, String empName, Double salary, String email) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.email = email;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee {employeeId=" + empId + ", employeeName=" + empName +
                ", salary=" + salary + ", email=" + email;
    }

    /*@Override
    public int compareTo(Employee o) {
        return this.getEmpName().compareTo(o.getEmpName());
    }*/
}
