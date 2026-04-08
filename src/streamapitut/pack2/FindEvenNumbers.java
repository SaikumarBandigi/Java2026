package streamapitut.pack2;

import java.util.List;

public class FindEvenNumbers {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        list.stream().filter(n -> (n & 1) == 0).forEach(System.out::println);

    }

}
