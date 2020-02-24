package hascodeAndequals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1);
        Employee emp2 = new Employee(1);

        Map<Employee, String> map = new HashMap<>();
        map.put(emp1, "jack");
        map.put(emp2, "def");
        System.out.println(map.size());
    }
}

class Employee{
    int id;

    public Employee(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}