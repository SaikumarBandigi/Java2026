package streamapitut.pack2;

import java.util.Comparator;
import java.util.List;

public class FindMaximumNumber {

    public static void main(String[] args) {

        List<Integer> list = List.of(10, 20, 5, 30, 30);
        list.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

    }

}
