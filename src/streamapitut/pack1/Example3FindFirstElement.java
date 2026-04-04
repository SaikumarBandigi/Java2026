package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;

public class Example3FindFirstElement {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(7, 8, 9);

        Integer res = list.stream().findFirst().get();
        System.out.println(res);

    }
}
