package com.octavioi;

import java.util.Iterator;

public class LinkedList2<T> implements Iterable<Node<T>> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            first = last = new Node<T>(item);
        }
        else {
            Node<T> temp = first;
            first = new Node<T>(item);
            first.next = temp;
        }
        size++;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            first = last = new Node<T>(item);
        }
        else {
            last.next = new Node<T>(item);
            last = last.next;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {
        if (isEmpty()) throw new IllegalArgumentException();
        if (first == last) first = last = null;
        else {
            Node<T> temp = first.next;
            first.next = null;
            first = temp;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) throw new IllegalArgumentException();
        if (first == last) first = last = null;
        else {
            Node<T> prevIndex = first;
            Node<T> index = first.next;
            while (index.next != null) {
                prevIndex = index;
                index = index.next;
            }
            last = prevIndex;
            last.next = null;
        }
        size--;
    }

    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    public int indexOf(T item) {
        int count = 0;
        for (var ele: this) {
            if (ele.value == item) return count;
            count++;
        }
        return -1;
    }

    public void reverse() {
        LinkedList2<T> temp = new LinkedList2<T>();
        Node<T> index = first;
        while(index != null) {
            Node<T> prevIndex = index;
            temp.addFirst(index.value);
            index = index.next;
            prevIndex.next = null;
        }
        this.first = temp.first;
        this.last = temp.last;
        this.size = temp.size();
    }

    // public T[] toArray() {
    //     Object[] temp = new Object[size()];
    //     T[] temp2 = (T[])temp;
    //     int count = 0;
    //     for (var item:this) {
    //         temp2[count++] = item;
    //     }
    //     return temp2;
    // }

    @Override 
    public String toString() {
        String res = "[";
        for (var item: this) {
            res += item.value + ", ";
        }
        return res + "]";
    }


    @Override
    public Iterator<Node<T>> iterator() {
        return new ListIterator(this);
    }

    public Node<T> kThNodeFromEnd(int k) {
        int count = 0;
        for (var item : this) {
            if (size - count++ == k) return item;
        }
        return null;
    }

    public Node<T> kThNodeFromEndWithoutUsingSize(int k) {
        if (isEmpty()) return null;
        Node<T> head = first;
        Node<T> tail = first;
        int count = 1;
        while (tail != null) {
            if (tail == last) return head;
            tail = tail.next;
            if (count++ >= k) {
                head = head.next;
            }
        }
        return null;

    }

    class ListIterator implements Iterator<Node<T>> {
        private Node<T> index;

        ListIterator(LinkedList2<T> items) {
            this.index = items.first;
        }

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Node<T> next() {
            Node<T> temp = index;
            index = index.next;
            return temp;
        }
    }


    
}

class Node<T> {
    public T value;
    public Node<T> next;

    Node(T item) {
        this.value = item;
    }
}
