package streamapitut.pack2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
HR -> D (60000)
IT -> C (70000)

 */

public class GroupEmployeesbyDepartmentANDFindHighestPaidEmployee {

    public static void main(String[] args) {

        List<Emp> employees = List.of(
                new Emp("A", "IT", 50000),
                new Emp("B", "HR", 40000),
                new Emp("C", "IT", 70000),
                new Emp("D", "HR", 60000),
                new Emp("E", "IT", 60000)
        );


        Map<String, Optional<Emp>> result =
                employees.stream().
                        collect(Collectors.groupingBy(Emp::getDepartment, Collectors.maxBy(Comparator.comparing(Emp::getSalary))));

        // Print result
        result.forEach(
                (dept, empOpt) ->
                        empOpt.ifPresent(emp -> System.out.println(dept + " -> " + emp.getName() + " (" + emp.getSalary() + ")"))
        );

    }


}

class Emp {
    String name;
    String department;

    public Emp(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
