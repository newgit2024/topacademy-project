package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiveCoding0707 {
    /*public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Ivan", List.of("admin", "superadmin")));
        users.add(new User("Lena", List.of("admin")));


        List<String> names = users.stream().map(User::getName).toList();
        System.out.println(names);


        var uniqueRoles = users.stream()
                .flatMap(u -> u.getRoles().stream())
                .distinct()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        System.out.println(uniqueRoles);


        int[] nums = {1, 2, 3, 4, 1, 2, 2};


        System.out.println(Stream.of(1, 2, 3, 4, 1, 2, 2)
                .collect(Collectors.toMap(a -> a, c -> 1, Integer::sum)));


        System.out.println(Stream.of(1, 2, 3, 4, 1, 2, 2)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting())));

        Map<Integer, Integer> statistic = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (statistic.containsKey(nums[i])) {
                statistic.put(nums[i], statistic.get(nums[i]) + 1);
            } else {
                statistic.put(nums[i], 1);
            }
        }


        System.out.println(statistic);


        //LinkedList<String>

    }
*/
}

