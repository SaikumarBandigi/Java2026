package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupThemBasedOnTheirFirstCharacter {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "ant", "banana", "bat", "cat", "car");

        Function<String, Character> function = s -> s.charAt(0);

        Map<Character, List<String>> map = words.stream().collect(Collectors.groupingBy(function));

        for (Character ch : map.keySet()) {
            System.out.println(ch + " " + map.get(ch));
        }


    }

}
