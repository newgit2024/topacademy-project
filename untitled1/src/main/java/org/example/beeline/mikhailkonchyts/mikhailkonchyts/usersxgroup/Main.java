package org.example.beeline.mikhailkonchyts.mikhailkonchyts.usersxgroup;
//Извините за недоразумение. Если у пользователя есть список групп, то вам нужно будет выполнить проверку для каждой группы в списке. Вот как это может выглядеть:

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = getUsers();










        List<User> usersWithGroupStartingWithX = users.stream()
                .filter(user -> user.getGroups().stream()
                        .anyMatch(group -> group.getName().startsWith("X")))
                .collect(Collectors.toList());

        usersWithGroupStartingWithX.forEach(System.out::println);


        System.out.println(users.stream()
                .filter(u -> u.getGroups()
                        .stream()
                        .anyMatch(group -> group
                                .getName()
                                .startsWith("X")))
                .collect(Collectors.toList()));
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", List.of(new Group("X123"), new Group("Y456"))));
        users.add(new User("Bob", List.of(new Group("Y456"), new Group("Z789"))));
        users.add(new User("Charlie", List.of(new Group("X789"), new Group("W012"))));
        users.add(new User("David", List.of(new Group("Z012"))));
        users.add(new User("Eve", List.of(new Group("X345"), new Group("A678"))));
        return users;
    }
}

class User {
    private String name;
    private List<Group> groups;

    public User(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}

class Group {
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}

//В данном коде будет выводиться список пользователей, у которых хотя бы одна группа начинается на "X".