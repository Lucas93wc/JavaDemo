package com.lucas.stream;

import java.util.Arrays;
import java.util.List;

public class TestForStream {
    public static void main(String[] args) {
        User u1 = new User(1, "aaa", 20);
        User u3 = new User(3, "ccc", 22);
        User u4 = new User(4, "ddd", 23);
        User u2 = new User(2, "bbb", 21);
        User u5 = new User(5, "eee", 24);

        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
//        users.stream()
//                .filter(user -> user.getId() % 2 != 0)
//                .filter(user -> user.getAge() > 21)
//                .map(user -> {
//                    user.setName(user.getName().toUpperCase());
//                    return user;
//                })
//                .sorted((o1, o2) -> o2.compareTo(o1))
//                .limit(1)
//                .forEach(System.out::println);
//        users.stream().mapToInt(user -> user.getAge()).forEach(System.out::println);



        users.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
    }
}
