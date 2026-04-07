package streamapitut.pack2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Extractnumbersfromamixedstringlist {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("sai", "123", "sonu", "456");

        String res = list.stream().
                filter(s -> s.chars().allMatch(Character::isDigit)).collect(Collectors.joining(","));
        System.out.println(res);

    }

}