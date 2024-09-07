package com.lucas.collection.abstractList;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc", "ddd");

        AbstractListTest<String> list = new AbstractListTest<>(1, 3, 5, 13);
        list.setData(stringList);


        AbstractListTest<String> list1 = new AbstractListTest<>();
        list1.setCurrentPageNo(1);
        list1.setTotalPageNo(3);
        list1.setPageSize(5);
        list1.setTotalSize(14);
        list1.setData(stringList);

        System.out.println("111");
    }
}
