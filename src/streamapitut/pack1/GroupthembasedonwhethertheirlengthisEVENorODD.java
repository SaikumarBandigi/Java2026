package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupthembasedonwhethertheirlengthisEVENorODD {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six");


        Function<String, String> function = s -> {
            if (s.length() % 2 == 0) return "EVEN";
            else return "ODD";
        };

        Map<String, List<String>> map = words.stream().collect(Collectors.groupingBy(function));

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

    }

}
