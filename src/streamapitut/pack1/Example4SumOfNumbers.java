package streamapitut.pack1;

import java.util.*;
import java.util.function.BinaryOperator;

public class Example4SumOfNumbers {
    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = Integer::sum;

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int res = list.stream().reduce(0, binaryOperator);
        System.out.println(res);

        int res1 = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(res1);

    }
}
