package streamapitut.pack2;

import java.util.Comparator;
import java.util.List;

public class Find2ndHighestNumber {
    public static void main(String[] args) {

        List<Integer> list = List.of(40, 40);
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

    }
}
