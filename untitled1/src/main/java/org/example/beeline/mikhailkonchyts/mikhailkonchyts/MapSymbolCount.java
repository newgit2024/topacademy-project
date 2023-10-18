package org.example.beeline.mikhailkonchyts.mikhailkonchyts;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapSymbolCount {
    public static void main(String[] args) {

        System.out.println(numbersCount2(""));
    }

    /*private static Map<Character, Long> numbersCount(String s){
        Map<Character, Long> characterLongMap = Optional.ofNullable(s).map(str -> str.chars()
                        .mapToObj(ch -> (char) ch)
                        //.mapToObj(Character::toChars)
                        //.collect(Collectors.groupingBy(String::valueOf, Collectors.counting());
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting())))
                .orElse(HashMap::new);
        return characterLongMap;
    }*/



    private static Map<String, Long> numbersCount2(String s) {
        return Optional.ofNullable(s)
                .map(str -> str.chars()
                        .mapToObj(Character::toChars)
                        .collect(Collectors
                                .groupingBy(String::valueOf,
                                        Collectors.counting())))
                .orElseGet(Collections::emptyMap);
    }
}
