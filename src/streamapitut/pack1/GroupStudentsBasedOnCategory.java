package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupStudentsBasedOnCategory {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ravi", 80),
                new Student("Anita", 65),
                new Student("Kiran", 45),
                new Student("Meena", 70),
                new Student("John", 30)
        );

        Function<Student, String> function = s -> {
            if (s.getMarks() >= 75) return "A";
            else if (s.getMarks() >= 50 && s.getMarks() <= 74) return "B";
            else return "C";
        };

        Map<String, List<Student>> result =
                students.stream()
                        .collect(Collectors.groupingBy(function));

        for (String s : result.keySet()) {
            System.out.println(s + " " + result.get(s));
        }

    }
}

class Student {
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    int marks;

}
