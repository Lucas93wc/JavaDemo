package com.lucas.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-11-30 15:33
 */
public class Remove {
    private List<String> list = new ArrayList<>();
    private Map<String, String> map = new HashMap<>();
    private Set<String> set = new HashSet<>();

    void init() {
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("b");
        list.add("d");

        map.put("aaa", "aaa");
        map.put("aba", "abc");
        map.put("aab", "aab");

        set.add("aa");
        set.add("bb");
        set.add("cc");
    }

    @Test
    public void testListRemove() {
        init();

        // 迭代器可以完全删除
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if ("b".equalsIgnoreCase(next)) {
//                iterator.remove();
//            }
//        }

        // 倒序遍历可以完全删除
//        for (int i = list.size()-1; i >= 0; i--) {
//            if ("b".equalsIgnoreCase(list.get(i))) {
//                list.remove(i);
//            }
//        }

        // 可以删除，但是因为删除造成列表长度缩减，索引会不连续，无法对全部数据进行判断
        // 删除原i下标的数据后，原(i+1)下标的数据会被跳过遍历
//        for (int i = 0; i < list.size(); i++) {
//            if ("b".equalsIgnoreCase(list.get(i))) {
//                list.remove(i);
//            }
//        }

        // 使用增强for循环删除
        // 出现异常：java.util.ConcurrentModificationException
        // 增强for循环使用迭代器，list.remove(s)未使用迭代器中的remove()，导致程序多并发判断时报错
        for (String s : list) {
            if ("b".equalsIgnoreCase(s)) {
                list.remove(s);
            }
        }

        for (String s : list) {
            System.out.println("List:"+ s);
        }
    }


}
