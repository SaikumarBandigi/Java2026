package streamapitut.pack1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupEmployeesbyDepartmentandFindAverageSalary {
    public static void main(String[] args) {


        List<StaffMember> staffList = Arrays.asList(
                new StaffMember(1, "Amit", "IT", 60000),
                new StaffMember(2, "Ravi", "IT", 70000),
                new StaffMember(3, "Neha", "HR", 50000),
                new StaffMember(4, "Sita", "HR", 55000),
                new StaffMember(5, "John", "Finance", 80000)
        );

        Map<String, Double> avgSalary =
                staffList.stream()
                        .collect(Collectors.groupingBy(
                                StaffMember::getDepartmentName,
                                Collectors.averagingDouble(StaffMember::getMonthlySalary)
                        ));

        for (String key : avgSalary.keySet()) {
            System.out.println(key + " " + avgSalary.get(key));
        }

    }

}

class StaffMember {

    int staffId;
    String fullName;
    String departmentName;
    double monthlySalary;

    public StaffMember(int staffId, String fullName, String departmentName, double monthlySalary) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.departmentName = departmentName;
        this.monthlySalary = monthlySalary;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return fullName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

}