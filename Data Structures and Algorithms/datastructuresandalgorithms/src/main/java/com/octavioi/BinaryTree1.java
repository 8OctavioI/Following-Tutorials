package com.octavioi;

public class BinaryTree1 {

    private Node root;

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node index = root;

        while (true) {
            if (val < index.value) {
                if (index.left == null) {
                    index.left = new Node(val);
                    return;
                } else {
                    index = index.left;
                }
            } else if (val >= index.value) {
                if (index.right == null) {
                    index.right = new Node(val);
                    return;
                } else {
                    index = index.right;
                }
            }
        }
    }

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    public void traversePreOrder(Node root) {
        Node index = root;
        if (index == null)
            return;
        System.out.print(index.value + ", ");
        traversePreOrder(index.left);
        traversePreOrder(index.right);
    }

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    public void traversePostOrder(Node index) {
        if (index == null)
            return;
        traversePostOrder(index.left);
        traversePostOrder(index.right);
        System.out.print(index.value + ", ");

    }

    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    public void traverseInOrder(Node index) {
        if (index == null)
            return;
        traverseInOrder(index.left);
        System.out.print(index.value + ", ");
        traverseInOrder(index.right);
    }

    public boolean find(int val) {
        Node index = root;
        if (index == null)
            return false;

        while (true) {
            if (val == index.value)
                return true;
            if (val < index.value) {
                if (index.left == null) {
                    return false;
                } else {
                    index = index.left;
                }
            } else if (val > index.value) {
                if (index.right == null) {
                    return false;
                } else {
                    index = index.right;
                }
            }
        }

    }

    private class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int val) {
            this.value = val;
        }

        Node(int val, Node left, Node right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + "]";
        }

    }
}
