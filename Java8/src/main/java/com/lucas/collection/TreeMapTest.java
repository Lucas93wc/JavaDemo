package com.lucas.collection;

import com.lucas.algorithm.redblacktree.RBTree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        test1();
    }

    public static void  test1() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] arr = { 4, 2, 6, 1, 3, 5, 15, 17};
        for (int i : arr) {
            treeMap.put(i, i);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey()+ "-" + next.getValue());
            if (next.getKey() == 1) iterator.remove();
        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey()+ "-" + entry.getValue());
        }
    }
}
