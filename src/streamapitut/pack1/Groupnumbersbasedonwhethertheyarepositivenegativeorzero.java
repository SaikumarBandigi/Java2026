package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Groupnumbersbasedonwhethertheyarepositivenegativeorzero {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, -5, 0, 7, -2, 0, 15);

        Function<Integer, String> function = integer -> {
            if (integer == 0) return "ZERO";
            if (integer > 0) return "POSITIVE";
            return "NEGATIVE";
        };

        Set<Map.Entry<String, List<Integer>>> entrySet =
                numbers.stream().collect(Collectors.groupingBy(function)).entrySet();


        for (Map.Entry<String, List<Integer>> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }

}
