package com.octavioi;

import java.util.Iterator;

public class List <T> implements Iterable<T>{

    private static final double DEFAULT_SIZE = 10;

    private T[] items;
    private int count;
    private int MaxIndex;

    List() {
        this(5);
    }

    List(Integer num){
        MaxIndex = closestDefaultSizeMultiple(num) - 1;
        items = (T[]) new Object[MaxIndex + 1];
        for (count = 0; count < num; count++) {
            items[count] = null;
        }
        count = 0;
    }

    List(T[] items) {
        this.MaxIndex = closestDefaultSizeMultiple(items.length) - 1;
        this.items = (T[]) new Object[MaxIndex + 1];
        count = 0;
        for (T item : items) {
            this.items[count++] = item;
        }
    }

    private int closestDefaultSizeMultiple(int num) {
        return (int) (Math.ceil(num / DEFAULT_SIZE) * DEFAULT_SIZE);

    }

    public T get(int index) {
        return items[index];
    }

    public int add(T item) {
        if (count < MaxIndex){
            this.items[count++] = item;
            return count;
        }
        MaxIndex += 10;
        T[] temp = (T[]) new Object[MaxIndex + 1];

        for (int i = 0; i < count; i++) {
            temp[i] = this.items[i]; 
        }
        temp[count++] = item;
        this.items = temp;
        return count;
    }

    public T remove(int index) {
        T temp = this.items[index];
        for(;index < count; index++) {
            this.items[index] = this.items[index + 1];
        }
        count--;
        return temp;
    }

    public int remove(T item) {
        int index = indexOf(item);
        if (index < 0) return -1;
        int temp = index;
        for(;temp < count; temp++) {
            this.items[temp] = this.items[temp + 1];
        }
        this.items[temp] = null;
        count--;
        return temp;

    }

    public int length() {
        return count;
    }

    public int indexOf(T item) {
        for (int i = 0; i < count; i++) {
            if (this.items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String res = "[";
        for (T item: this) {
            res += item + ", ";
        }
        res += "]";
        return res;

    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<T> {
        private int index;
        private List<T> list;

        ListIterator(List<T> list){
            this.index = 0;
            this.list = list;
        }
        @Override
        public boolean hasNext(){
            return list.get(index) != null;
        }

        @Override
        public T next(){
            return list.get(index++);  
        }
    }


    
}
