package com.octavioi;

import java.util.Iterator;

public class LinkedList1 <T> implements Iterable<T>{
    private Node1<T> first;
    private Node1<T> last;

    LinkedList1() {
    }

    private void firstAdd(T item) {
        first = new Node1<T>(item);
        last = first;
    }

    public void addFirst(T item) {
        if (first == null) {
            firstAdd(item);
            return;
        }
        Node1<T> temp = first;
        this.first = new Node1<T>();
        first.value = item;
        first.next = temp;
    }

    public void addLast(T item) {
        if (first == null) {
            firstAdd(item);
            return;
        }
        last.next = new Node1<>();
        last.next.value = item;
        last = last.next;
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void deleteLast() {
        Node1<T> prevIndex = first;
        Node1<T> index = prevIndex.next;
        while(index != last) {
            prevIndex = index;
            index = index.next;
        }
        last = prevIndex;
    }

    public int indexOf(T item) {
        int count = 0;
        for (T item2 : this)  {
            if (item2 == item) return count;
            count++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    public int size() {
        return indexOf(last.value) + 1;
    }

    public T[] toArray() {
        T[] newArray = (T[]) new Object[size()];
        int index = 0;
        for (var item: this) {
            newArray[index++] = item;
        }
        return newArray;
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }
    

    @Override
    public String toString(){
        if (first == null) return "[ ]";
        String res = "[";
        for (T item: this) {
            res += item + ", ";
        }
        res += "]";
        return res;
    }

    private class ListIterator implements Iterator<T> {
        private Node1<T> index;
        private Node1<T> last;

        ListIterator(LinkedList1<T> items) {
            this.index = items.first;
            this.last = items.last;
        }
        public boolean hasNext() {
            return index != last.next;
        }
        public T next() {
            T temp = this.index.value;
            index = index.next;
            return temp;
        }
    }
    
}
