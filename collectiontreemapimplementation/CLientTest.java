package collectiontreemapimplementation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CLientTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "ram", 90000.0, "sam@infotect.com");
        Employee e2 = new Employee(2, "sam", 10000.0, "abc@infotect.com");
        Employee e3 = new Employee(3, "shyamam", 20000.0, "def@infotect.com");
        Employee e4 = new Employee(4, "ghanam", 30000.0, "ijk@infotect.com");
        Employee e5 = new Employee(5, "jagan", 40000.0, "swe@infotect.com");

        Department d1 = new Department(1001, "IT", "BOSTON");
        Department d2 = new Department(1002, "FINANCE", "CHENNAI");

        //Map<Employee, Department> map = new TreeMap<>();
        Map<Employee, Department> map = new TreeMap<>(new SortBEmployeeSalary());

        map.put(e1, d1);
        map.put(e2, d1);
        map.put(e3, d1);

        map.put(e4, d2);
        map.put(e5, d2);

        Set<Map.Entry<Employee, Department>> entrySet = map.entrySet();
        Iterator<Map.Entry<Employee, Department>> itr = entrySet.iterator();
        while (itr.hasNext()) {
            Map.Entry<Employee, Department> entry = itr.next();
            Employee employee = entry.getKey();
            Department department = entry.getValue();
            System.out.println(employee);
            System.out.println(department);
        }
    }
}
