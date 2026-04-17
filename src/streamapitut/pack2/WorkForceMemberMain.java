package streamapitut.pack2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
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

        Map<String, Map<String, Object>> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                WorkforceMember::getDepartment,
                                Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    Map<String, Object> map = new HashMap<>();

                                    map.put("count", list.size());

                                    List<WorkforceMember> highEarners = list.stream()
                                            .filter(e -> e.getSalary() > 50000)
                                            .collect(Collectors.toList());

                                    map.put("highEarners", highEarners);

                                    return map;
                                })
                        ));

        BiConsumer<String, Map<String, Object>> biConsumer = new BiConsumer<>() {
            @Override
            public void accept(String dept, Map<String, Object> data) {
                System.out.println("Department: " + dept);
                System.out.println("Count: " + data.get("count"));
                System.out.println("High Earners: " + data.get("highEarners"));
                System.out.println();
            }
        };

        result.forEach(biConsumer);

    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkforceMember)) return false;
        WorkforceMember that = (WorkforceMember) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
