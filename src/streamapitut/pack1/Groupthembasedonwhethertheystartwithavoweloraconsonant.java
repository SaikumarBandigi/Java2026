package streamapitut.pack1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Groupthembasedonwhethertheystartwithavoweloraconsonant {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "umbrella", "cat");

        Function<String, String> function = s -> {
            if (isVowel(s.charAt(0))) {
                return "VOWEL";
            }
            return "CONSONANT";
        };

        Map<String, List<String>> map = words.stream().collect(Collectors.groupingBy(function));

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }


    }

    static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

}
