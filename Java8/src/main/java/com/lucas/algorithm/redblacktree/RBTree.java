package com.lucas.algorithm.redblacktree;

import static com.lucas.algorithm.redblacktree.Color.BLACK;

/**
 * 红黑树性质
 * 1. 每个结点不是红色就是黑色
 * 2. 根节点是黑色的
 * 3. 如果一个节点是红色的，则它的两个孩子结点是黑色的
 * 4. 对于每个结点，从该结点到其所有后代叶结点的简单路径上，均 包含相同数目的黑色结点
 * 5. 每个叶子结点都是黑色的(此处的叶子结点指的是空结点)
 *
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>, V> {
    private RBTreeNode<K, V> root;

    public RBTree() {
        this.root = null;
    }

    public boolean insert(K k, V v) {
        if (root == null) {
            root = new RBTreeNode<>(k, v);
            root.setColor(BLACK);
            return true;
        }

        // 循环遍历找到待添加节点的父节点
        RBTreeNode<K, V> parent = null;
        RBTreeNode<K, V> cur = root;
        while (cur != null) {
            if (cur.getKey().compareTo(k) < 0) {
                parent = cur;
                cur = cur.getRight();
            }
            else if (cur.getKey().compareTo(k) > 0) {
                parent = cur;
                cur = cur.getLeft();
            }
            else {
                return false;
            }
        }

        // 比较待添加节点的key值，将待添加节点放入父节点的左子节点或右子节点
        cur = new RBTreeNode<>(k, v);
        if (parent.getKey().compareTo(k) < 0) {
            parent.setRight(cur);
            cur.setParent(parent);
        }
        else {
            parent.setLeft(cur);
            cur.setParent(parent);
        }

        // 红黑树开整
        // 1.cur为红，parent为红，grandfather为黑，uncle存在且为红
        // 解决方法：p,u变成黑，g变成红，c=g，继续向上调整
        // 2.cur为红，parent为红，grandfather为黑,uncle不存在 or 存在且为黑
        // 解决方法: 单旋：p变红，g变黑，//双旋：c变黑，g变红

        return true;
    }

    public static void main(String[] args) {
        RBTree<Integer, String> rbTree = new RBTree<>();
    }
}

