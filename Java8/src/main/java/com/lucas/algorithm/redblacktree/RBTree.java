package com.lucas.algorithm.redblacktree;

import java.util.LinkedList;

import static com.lucas.algorithm.redblacktree.Color.BLACK;
import static com.lucas.algorithm.redblacktree.Color.RED;

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

        //parent不为空，且parent->_col==RED（这样保证肯定有祖先，也就是grandfather不为空）
        while (parent != null && parent.getColor().equals(RED)) {
            //    g
            //  p   u
            //c
            RBTreeNode<K, V> grandFather = parent.getParent();
            if (parent == grandFather.getLeft()) {
                //    g
                //  p   u
                //c
                RBTreeNode<K, V> uncle = grandFather.getRight();
                if (uncle != null && uncle.getColor().equals(RED)) {
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    grandFather.setColor(RED);

                    //继续往上更新处理
                    cur = grandFather;
                    parent = cur.getParent(); //这儿parent更新完之后可能为空，为空就结束
                }
                else {  //uncle不存在 or 存在且为黑
                    // 单旋
                    //    g
                    //  p   u
                    //c
                    if (cur == parent.getLeft()) {
                        rotateR(grandFather);
                        parent.setColor(BLACK);
                        grandFather.setColor(RED);
                    }
                    else if (cur == parent.getRight()) {
                        //双旋
                        //    g
                        //  p   u
                        //    c
                        rotateL(parent);
                        rotateR(grandFather);
                        cur.setColor(BLACK);
                        grandFather.setColor(RED);
                    }

                    break;
                }
            }
            //    g
            //  u   p
            //        c
            else {  //  parent == grandfather->_right
                RBTreeNode<K, V> uncle = grandFather.getLeft();
                if (uncle != null && uncle.getColor().equals(RED)) {
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    grandFather.setColor(RED);

                    //继续往上更新处理
                    cur = grandFather;
                    parent = cur.getParent();
                }
                else {  //(uncle不存在 or 存在且为黑)
                    if (cur == parent.getRight()) {
                        rotateL(grandFather);
                        parent.setColor(BLACK);
                        grandFather.setColor(RED);
                    }
                    else {  //cur == parent->_left
                        //双旋
                        //    g
                        //  u   p
                        //    c
                        rotateR(parent);
                        rotateL(grandFather);
                        cur.setColor(BLACK);
                        grandFather.setColor(RED);
                    }
                    break;
                }
            }
        }

        //管你根节点更新成啥了，管你个求，直接把_root->_col改成黑色
        root.setColor(BLACK);

        return true;
    }

    //右单旋
    private void rotateR(RBTreeNode<K,V> parent) {
        RBTreeNode<K, V> subL = parent.getLeft();
        RBTreeNode<K, V> subLR = subL.getRight();

        //旋转链接
        //动一个节点就把他的父亲也变动
        parent.setLeft(subLR);
        if (subLR != null) {    //SubLR可能为空
            subLR.setParent(parent);
        }

        RBTreeNode<K, V> parentParent = parent.getParent();

        subL.setRight(parent);
        parent.setParent(subL);

        //和父节点的父节点链接
        if (root == parent) {
            root = subL;
            subL.setParent(null);
        }
        else {
            if (parentParent.getLeft() == parent)
                parentParent.setLeft(subL);
            else
                parentParent.setRight(subL);

            subL.setParent(parentParent); //链接
        }
    }

    //左单旋
    //（1.父亲节点的右边等于右孩子的左边; 2.右孩子的左边等于父亲节点）
    //【把右孩子的左边给给父亲节点的右边; 2.再把父亲节点给给右孩子的左边】
    private void rotateL(RBTreeNode<K,V> parent) {
        RBTreeNode<K, V> subR = parent.getRight();
        RBTreeNode<K, V> subRL = subR.getLeft();

        //旋转链接
        parent.setRight(subRL);
        if (subRL != null) {
            subRL.setParent(parent);
        }

        RBTreeNode<K, V> parentParent = parent.getParent();

        subR.setLeft(parent);
        parent.setParent(subR);

        //和父节点的父节点链接
        if (root == parent) {
            root = subR;
            subR.setParent(null);
        }
        else {
            if (parentParent.getLeft() == parent)
                parentParent.setLeft(subR);
            else
                parentParent.setRight(subR);

            subR.setParent(parentParent);
        }
    }

    // 中序遍历
    public void inOrder() {
        _inOrder(root);
        System.out.println();
    }

    private void _inOrder(RBTreeNode<K,V> root) {
        if (root == null) return;

        _inOrder(root.getLeft());
        System.out.print(root.getKey()+ "."+ root.getColor() + " ");
        _inOrder(root.getRight());
    }

    private void inOrder1() {
        _inOrder1(root);
        System.out.println();
    }
    private void _inOrder1(RBTreeNode<K,V> root) {
        if (root == null) return;
        RBTreeNode<K, V> left = root.getLeft();
        RBTreeNode<K, V> right = root.getRight();

        _inOrder1(left);

//        System.out.print(root.getKey()+ "."+ root.getColor() + " ");
        System.out.print("root: " + root.getKey()+ "."+ root.getColor() + " ");
        if (left != null) System.out.print("left: " + left.getKey()+ "."+ left.getColor() + " ");
        if (right != null) System.out.print("right: " + right.getKey()+ "."+ right.getColor() + " ");
        System.out.println();

        _inOrder1(right);

    }

    public void levelOrder() {
        LinkedList<RBTreeNode<K,V>> queue = new LinkedList<>();
        queue.add(root);

        _levelOrder(queue);
//        System.out.println();
    }
    private void _levelOrder(LinkedList<RBTreeNode<K,V>> queue) {
        if (queue.isEmpty()) return;

        LinkedList<RBTreeNode<K,V>> newQueue = new LinkedList<>();
        for (RBTreeNode<K, V> node : queue) {
            RBTreeNode<K, V> left = node.getLeft();
            RBTreeNode<K, V> right = node.getRight();
            RBTreeNode<K, V> parent = node.getParent();

            if (left != null) newQueue.add(left);
            if (right != null) newQueue.add(right);

            System.out.print("[");
            if (parent != null) System.out.print("parent: " + parent.getKey()+ "."+ parent.getColor() + " ");
            System.out.print("node: " + node.getKey()+ "."+ node.getColor() + "] ");
        }
        System.out.println();

        _levelOrder(newQueue);
    }

    //根节点到当前这条路径的黑色节点个数
    private boolean check(RBTreeNode<K,V> root, int blackNum, final int refVal) {
        if (root == null) {
            return blackNum == refVal;
        }

        //直接反向检查，儿子很复杂，父亲只有一个
//        if (root.getColor().equals(RED) && (root.getParent() != null && RED.equals(root.getParent().getColor()))) {
        if (root.getColor().equals(RED) && RED.equals(root.getParent().getColor())) {
            System.out.println("有连续的红节点");
            return false;
        }

        if (root.getColor().equals(BLACK)) blackNum++;

        return check(root.getLeft(), blackNum, refVal) && check(root.getRight(), blackNum, refVal);
    }

    private boolean isBalance() {
        if (root == null) return true;

        if (root.getColor().equals(RED)) return false;

        int blackNum = 0;   //记录每条路径的黑色节点个数
        int refVal = 0;     //定一个标准
        RBTreeNode<K,V> cur = root;
        while (cur != null) {
            if (cur.getColor().equals(BLACK)) refVal++;

            cur = cur.getLeft();
        }

        return check(root, blackNum, refVal);
    }

    public static void main(String[] args) {
        RBTree<Integer, String> rbTree = new RBTree<>();
        int[] arr = { 4, 2, 6, 1, 3, 5, 15, 7, 16, 14 };
        for (int i : arr) {
            rbTree.insert(i, String.valueOf(i));
        }

        System.out.println("中序遍历：");
        rbTree.inOrder();
        System.out.println("层序遍历：");
        rbTree.levelOrder();
    }
}

