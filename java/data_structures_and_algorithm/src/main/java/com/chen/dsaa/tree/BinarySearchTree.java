package com.chen.dsaa.tree;

/**
 * 二叉搜索树
 *
 */
public class BinarySearchTree<AnyType extends Comparable<? extends AnyType>> {
    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    /*
    public boolean contains(AnyType element) {
        return contains(element, root);
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new NullPointerException("");
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty())
            throw new NullPointerException("");
        return findMax(root).element;
    }

    public void insert(AnyType element) {
        root = insert(element, root);
    } 
    */

    class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> leftTree;
        BinaryNode<AnyType> rightTree;

        BinaryNode(AnyType element, BinaryNode<AnyType> ltree, BinaryNode<AnyType> rtree) {
            this.element = element;
            this.leftTree = ltree;
            this.rightTree = rtree;
        }

        BinaryNode(AnyType element) {
            this(element, null, null);
        }
    }

    /*
    private boolean contains(AnyType element, BinaryNode<AnyType> node) {
        if (node == null)
            return false;
        int compareResult = element.compareTo(node.element);
        if (compareResult < 0)
            return contains(element, node.leftTree);
        else if (compareResult > 0)
            return contains(element, node.rightTree);
        else
            return true;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node) {
        if (node == null)
            return null;
        else if (node.leftTree == null)
            return node;
        else
            return findMin(node.leftTree);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node) {
        if (node == null)
            return null;
        while (node.rightTree != null)
            node = node.rightTree;
        return node;
    }

    private BinaryNode<AnyType> insert(AnyType element, BinaryNode<AnyType> node) {
        if (node == null)
           return new BinaryNode<>(element, null, null);
        int compareResult = element.compareTo(node.element);
        if (compareResult > 0)
            node.leftTree = insert(element, node.leftTree);
        else if (compareReulst < 0)
            node.rightTree = insert(element, node.rightTree);
        else
            //do nothing
        return node;
    } 
    */
}
