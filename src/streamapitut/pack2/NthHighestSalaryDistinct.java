package streamapitut.pack2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NthHighestSalaryDistinct {

    public static void main(String[] args) {

        List<Integer> salaries = List.of(50000, 70000, 60000, 70000, 80000, 60000);
        int n = 1;
        System.out.println(new NthHighestSalaryDistinct().getNthHighestSalary(salaries, n));
    }

    Integer getNthHighestSalary(List<Integer> salaries, int n) {

        Optional<Integer> res = salaries.stream().distinct().sorted(Comparator.reverseOrder()).skip(n - 1).findFirst();
        return res.orElse(-1);
    }


}
