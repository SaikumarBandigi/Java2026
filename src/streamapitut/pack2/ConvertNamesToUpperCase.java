package streamapitut.pack2;

import java.util.List;

public class ConvertNamesToUpperCase {
    public static void main(String[] args) {

        List<String> names = List.of("john", "alice", "bob");
        names.stream().map(String::toUpperCase).forEach(System.out::println);


    }
}
