package com.lucas.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-12-01 9:52
 */
public class ListTest {
    private List<String> list = null;

    @Test
    public void test02() {
        List<String> list01 = null;
        List<String> list02 = new ArrayList<>();
        test01(list01);
        test01(list02);

        if (list01 != null) list01.forEach(obj -> System.out.println("list01:"+obj));
        if (list02 != null) list02.forEach(obj -> System.out.println("list02:"+obj));

        List<String> linkedList = new LinkedList<>();
    }

    public void test01(List<String> list) {
        if (null == list) list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
    }


}
