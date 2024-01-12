package com.lucas.optional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Lucas
 * @Description TODO
 * @date 2022-06-08 16:52
 */
public class OptionalTest {

    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");

        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
//        long count = stream.count();
//        System.out.println(count);
        stream.flatMap(new Function<List<String>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<String> strings) {

                return strings.stream();
            }
        }).forEach(System.out::println);
        System.out.println("=================");
        Stream<List<String>> stream2 = optional.stream();
        stream2.flatMap(x -> x.stream()).forEach(System.out::println);

    }

}
