package com.lucas.algorithm.redblacktree;

import static com.lucas.algorithm.redblacktree.Color.RED;

public class RBTreeNode<K, V> {
    private RBTreeNode<K, V> left;
    private RBTreeNode<K, V> right;
    private RBTreeNode<K, V> parent;
    K key;
    V value;

    // 平衡因子
    int bf;

    private Color color;

    public RBTreeNode(K k, V v) {
        this.key = k;
        this.value = v;
        left = null;
        right = null;
        parent = null;
        color = RED;
    }

    public RBTreeNode() {

    }

    public RBTreeNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode<K, V> left) {
        this.left = left;
    }

    public RBTreeNode<K, V> getRight() {
        return right;
    }

    public void setRight(RBTreeNode<K, V> right) {
        this.right = right;
    }

    public RBTreeNode<K, V> getParent() {
        return parent;
    }

    public void setParent(RBTreeNode<K, V> parent) {
        this.parent = parent;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
