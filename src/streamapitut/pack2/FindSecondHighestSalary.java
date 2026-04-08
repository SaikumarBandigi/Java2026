package streamapitut.pack2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondHighestSalary {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("A", 50000),
                new Employee("B", 70000),
                new Employee("C", 60000),
                new Employee("D", 70000)
        );


        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().ifPresent(System.out::println);




    }

}

class Employee {
    String name;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}