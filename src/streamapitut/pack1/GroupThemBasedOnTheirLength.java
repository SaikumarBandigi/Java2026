package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupThemBasedOnTheirLength {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("hi", "hello", "cat", "dog", "elephant", "bat");

        Function<String, Integer> function = String::length;

        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(function));

        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }

    }
}
