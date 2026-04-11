package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupNumbersbasedontheirremainderwhendividedby3 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Function<Integer, Integer> function = num -> num % 3;

        Map<Integer, List<Integer>> map = numbers.stream().collect(Collectors.groupingBy(function));

        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }


    }

}
