package streamapitut.pack2;

import java.util.Arrays;
import java.util.List;

public class Example {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(5, 12, 8, 20, 3);

        list.stream()
                .filter(x -> x > 10)
                .forEach(System.out::println);

    }

}
