package com.lucas.algorithm.redblacktree;

public class Test {
    public static void main(String[] args) {
        //int[] arr = { 4, 2, 6, 1, 3, 5, 15, 7, 16, 14, 11, 8};
        int[] arr = { 4, 2, 6, 1, 3, 5, 15, 17};
        RBTree<Integer, Integer> tree = new RBTree<>();
        for (int i : arr) {
            tree.insert(i, i);
        }

        System.out.println("中序遍历：");
        tree.inOrder();

        System.out.println();

        System.out.println("层序遍历：");
        tree.levelOrder();
    }
}
