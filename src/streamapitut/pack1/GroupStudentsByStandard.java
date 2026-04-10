package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class GroupStudentsByStandard {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ram", "John", "Asha", "Kiran", "Tom");

        Map<Integer, List<String>> map = names.stream().collect(Collectors.groupingBy(String::length));

        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }


    }

}

