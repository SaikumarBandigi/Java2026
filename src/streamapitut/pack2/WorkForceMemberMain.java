package streamapitut.pack2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WorkForceMemberMain {
    public static void main(String[] args) {

        List<WorkforceMember> employees = List.of(
                new WorkforceMember(1, "Alice", "IT", 60000),
                new WorkforceMember(2, "Bob", "HR", 40000),
                new WorkforceMember(3, "Charlie", "IT", 70000),
                new WorkforceMember(4, "David", "Finance", 55000),
                new WorkforceMember(5, "Eve", "HR", 65000),
                new WorkforceMember(6, "Frank", "Finance", 45000)
        );


        Function<List<WorkforceMember>, Map<String, Object>> function = new Function<>() {
            @Override
            public Map<String, Object> apply(List<WorkforceMember> list) {
                Map<String, Object> map = new HashMap<>();
                map.put("count", list.size());
                List<WorkforceMember> memberList = list.stream().filter(w -> w.getSalary() > 50000).toList();
                map.put("highEarners", memberList);
                return map;
            }
        };


        Map<String, Map<String, Object>> map = employees.stream()
                .collect(Collectors.groupingBy(WorkforceMember::getDepartment
                        , Collectors.collectingAndThen(Collectors.toList(), function)));


        map.forEach((dept, m) -> {
            System.out.println(dept);
            System.out.println(m.get("count"));
            System.out.println(m.get("highEarners"));
            System.out.println();
        });


    }

//    private static Map<String, Object> processDepartment(List<WorkforceMember> list) {
//        Map<String, Object> map = new HashMap<>();
//        // count
//        map.put("count", list.size());
//        // filter high earners
//        List<WorkforceMember> highEarners = list.stream()
//                .filter(e -> e.getSalary() > 50000)
//                .collect(Collectors.toList());
//        map.put("highEarners", highEarners);
//        return map;
//    }
}


class WorkforceMember {
    private int id;
    private String name;
    private String department;
    private double salary;

    public WorkforceMember(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }

}
/*

You are given a list of WorkforceMember objects containing id, name, department, and salary.
Using Java 8 Stream API:

Group the employees by department
For each department:
Calculate total number of employees
Collect employees with salary greater than 50,000

 */