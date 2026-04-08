package streamapitut.pack2;

import java.util.*;
import java.util.stream.Collectors;

public class FindSecondHighestSalary {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("A", "IT", 50000, 30),
                new Employee("C", "IT", 60000, 26),
                new Employee("D", "HR", 40000, 24),
                new Employee("E", "HR", 45000, 29),
                new Employee("F", "HR", 45000, 32),
                new Employee("G", "Sales", 80000, 35)
        );

        Map<String, List<Employee>> result =
                employees.stream().filter(e -> e.getAge() >= 25).collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream().
                        map(entry -> {
                            List<Employee> deptEmployees = entry.getValue();
                            List<Double> sortedSalaries = deptEmployees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).toList();
                            if (sortedSalaries.size() < 2) return null;
                            double secondHighest = sortedSalaries.get(1);
                            List<Employee> secondHighestEmployees = deptEmployees.stream().filter(e -> e.getSalary() == secondHighest).toList();
                            return Map.entry(entry.getKey(), secondHighestEmployees);
                        }).filter(Objects::nonNull).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        result.forEach((dept, empList) -> System.out.println(dept + " -> " + empList));
    }

    static class Employee { // ✅ FIXED
        String name;
        String department;
        double salary;
        int age;

        Employee(String name, String department, double salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " (" + salary + ")";
        }
    }
}