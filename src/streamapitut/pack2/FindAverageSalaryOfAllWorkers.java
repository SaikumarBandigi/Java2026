package streamapitut.pack2;

import java.util.*;
import java.util.stream.Collectors;

public class FindAverageSalaryOfAllWorkers {
    public static void main(String[] args) {

        List<Worker> workers = Arrays.asList(
                new Worker(101, "Amit", "IT", 60000),
                new Worker(102, "Neha", "HR", 50000),
                new Worker(103, "Raj", "IT", 75000),
                new Worker(104, "Sneha", "Finance", 65000),
                new Worker(105, "Karan", "HR", 55000),
                new Worker(106, "Pooja", "Finance", 70000));


        Double avgSalaray = workers.stream().mapToDouble(Worker::getSalary).average().orElse(0.0);
        System.out.println(avgSalaray);  // 62500.0

        System.out.println();

        List<Worker> workerList = workers.stream().filter(w -> w.getSalary() > avgSalaray).toList();

        for (Worker w : workerList) {
            System.out.println(w.getName());
        }

        System.out.println();


        Map<String, List<Worker>> mapWorkers = workers.stream().collect(Collectors.groupingBy(Worker::getDepartment));

        for (String s : mapWorkers.keySet()) {
            List<Worker> works = mapWorkers.get(s);
            System.out.print(s + " ");
            for (Worker w : works) {
                System.out.print(w.getName() + " ");
            }
            System.out.println();

        }

        System.out.println();


        Map<String, Optional<Worker>> optionalMap = workers.stream().collect(
                Collectors.groupingBy(
                        Worker::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Worker::getSalary))));

        for (String s : optionalMap.keySet()) {
            System.out.println(s + " " + optionalMap.get(s).orElse(new Worker()).getName());
        }

        System.out.println();

    }

}

class Worker {

    private int empId;

    public Worker() {
    }

    private String name;
    private String department;
    private double salary;


    @Override
    public String toString() {
        return "Worker{" + "empId=" + empId + ", name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
    }


    public Worker(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
