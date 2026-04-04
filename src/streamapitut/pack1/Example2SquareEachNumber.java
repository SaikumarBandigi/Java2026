package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;

public class Example2SquareEachNumber {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().map(n -> n * n).forEach(System.out::println);


    }
}
