package streamapitut.pack2;

import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("A", 50000),
                new Employee("B", 70000),
                new Employee("C", 60000)
        );


        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)).forEach(System.out::println);

    }
}

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


class CustomSalComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}