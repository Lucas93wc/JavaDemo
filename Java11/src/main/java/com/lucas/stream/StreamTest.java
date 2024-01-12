package com.lucas.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lucas
 * @Description TODO
 * @date 2022-06-14 19:13
 */
public class StreamTest {
    @Test
    public void test01() {
        User u1 = new User(1, "aaa", 20);
        User u2 = new User(2, "bbb", 21);
        User u3 = new User(3, "ccc", 22);
        User u4 = new User(4, "ddd", 23);
        User u5 = new User(5, "eee", 24);
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);

        users.stream().dropWhile(user -> user.getId() > 3).forEach(System.out::println);
//        Stream.of(1, 2, 3, 2, 4, 1)
//                .dropWhile(n -> n < 3)
//                .forEach(System.out::println);
//        System.out.println("===========================");

//        users.stream().takeWhile(user -> user.getId() < 3).forEach(user -> System.out.println(user));
//        System.out.println("===========================");
//        users.stream().takeWhile(new Predicate<User>() {
//            @Override
//            public boolean test(User user) {
//                System.out.println(user);
//                boolean result = user.getId() < 3;
//                return result;
//            }
//        }).forEach(user -> System.out.println(user.getName()));
    }
}
