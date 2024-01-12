package com.lucas.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-11-24 13:06
 */
public class MapTest {
    private Map<String, String> map1 = new HashMap<>();
    private Map<String, String> map2 = new LinkedHashMap<>();
    private Map<String, String> map3 = new Hashtable<>();
    private Map<String, String> map4 = new TreeMap<>();

    private void init() {
        for (int i=0; i<10; i++) {
            map1.put(String.valueOf(i), String.valueOf(i));
            map2.put(String.valueOf(i), String.valueOf(i));
            map3.put(String.valueOf(i), String.valueOf(i));
            map4.put(String.valueOf(i), String.valueOf(i));
        }
    }

    private void init2() {
        map1.put("张三", "张三");
        map1.put("李四", "李四");
        map1.put("王五", "王五");
        map1.put("aaa", "aaa");
        map1.put("aba", "abc");
        map1.put("aab", "aab");

        map2.put("张三", "张三");
        map2.put("李四", "李四");
        map2.put("王五", "王五");
        map2.put("aaa", "aaa");
        map2.put("aba", "abc");
        map2.put("aab", "aab");
    }

    @Test
    public void MapOrderTest() {
        init();
        map4.put("1", "2");

        Set<Map.Entry<String, String>> entries = map4.entrySet();


        Iterator<Map.Entry<String, String>> iterator = map4.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
//            if (next.getKey().equals("1") || next.getKey().equals("6"))
//                iterator.remove();
        }
//        System.out.println(map3);
//        for (Map.Entry<String, String> entry : map1.entrySet()) {
//            System.out.println("key:"+ entry.getKey() + " --- value:"+ entry.getValue());
//        }
//
//        System.out.println("--------------------------------");
//        for (Map.Entry<String, String> entry : map2.entrySet()) {
//            System.out.println("key:"+ entry.getKey() + " --- value:"+ entry.getValue());
//        }
    }
}
