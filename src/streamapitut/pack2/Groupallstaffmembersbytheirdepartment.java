package streamapitut.pack2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Groupallstaffmembersbytheirdepartment {
    public static void main(String[] args) {


        List<StaffProfile> staffList = Arrays.asList(
                new StaffProfile("Amit", "IT", 60000),
                new StaffProfile("Ravi", "HR", 40000),
                new StaffProfile("Sneha", "IT", 75000),
                new StaffProfile("Pooja", "Finance", 50000),
                new StaffProfile("Kiran", "HR", 45000)
        );


        Map<String, List<StaffProfile>> map = staffList.stream().collect(Collectors.groupingBy(StaffProfile::getDepartment));

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }

        System.out.println();

        Map<String, Double> map1 = staffList.stream().
                collect(Collectors.groupingBy(
                        StaffProfile::getDepartment, Collectors.averagingInt(StaffProfile::getSalary))
                );

        for (String s : map1.keySet()) {
            System.out.println(s + " " + map1.get(s));
        }


    }
}

class StaffProfile {

    String name;
    String department;
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

    public StaffProfile(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String toString() {
        return name;
    }

}

