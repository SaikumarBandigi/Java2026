package streamapitut.pack2;

import java.util.List;

public class CountStringsStarttingWithA {
    public static void main(String[] args) {

        List<String> names = List.of("Anil", "Bob", "Alice", "David");

        long res = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(res);

    }
}
