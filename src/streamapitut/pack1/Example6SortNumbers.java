package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;

public class Example6SortNumbers {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 8, 1);
        list.stream().sorted().forEach(System.out::println);

    }
}
