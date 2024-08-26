package com.octavioi;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class List2 <T> implements Collection<T> {

    private static final double DEFAULT_SIZE = 10;

    protected T[] items;
    private int count;
    private int MaxIndex;

    List2() {
        this((int)DEFAULT_SIZE);
    }

    List2(int num) {
        MaxIndex = closestDefaultSizeMultiple(num) - 1;
        items = (T[]) new Object[MaxIndex + 1];
        for (count = 0; count < num; count++) {
            items[count] = null;
        }
        count = 0;
    }

    List2(T[] items) {
        this.MaxIndex = closestDefaultSizeMultiple(items.length) - 1;
        this.items = (T[]) new Object[MaxIndex + 1];
        count = 0;
        for (T item : items) {
            this.items[count++] = item;
        }
    }

    @Override
    public int size() {
        return count;
    }

    public int length() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override 
    public void clear() {
        int num = (int) DEFAULT_SIZE;
        MaxIndex = closestDefaultSizeMultiple(num) - 1;
        items = (T[]) new Object[MaxIndex + 1];
        for (count = 0; count < num; count++) {
            items[count] = null;
        }
        count = 0;
    }

    @Override
    public boolean add(T item) {
        if (count < MaxIndex){
            this.items[count++] = item;
            return true;
        }
        MaxIndex += 10;
        T[] temp = (T[]) new Object[MaxIndex + 1];

        for (int i = 0; i < count; i++) {
            temp[i] = this.items[i]; 
        }
        temp[count++] = item;
        this.items = temp;
        return true;
    }

    @Override 
    public boolean addAll(Collection<? extends T> collection) {
        for (var item: collection) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        T[] temp = (T[]) new Object[count];
        count = 0;
        for (var item:  collection) {
            if (contains(item)) temp[count++] = (T) item;
        }
        this.items = temp;
        MaxIndex = closestDefaultSizeMultiple(count) - 1;
        return true;
    }

    public T get(int index) {
        return this.items[index];
    }

    @Override
    public boolean contains(Object item) {
        return indexOf((T) item) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(var item: collection) {
            if (contains(item) == false) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(){
        return items;
    }

    @Override
    public <T> T[] toArray(T[] var1) {
        return (T[]) items;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for(var item: collection) {
            remove(item);
        }
        return true;
    }



    @Override
    public boolean remove(Object item) {
        int index = indexOf((T) item);
        if (index < 0) return false;
        int temp = index;
        for(;temp < count; temp++) {
            this.items[temp] = this.items[temp + 1];
        }
        this.items[temp] = null;
        count--;
        return true;
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

    private int closestDefaultSizeMultiple(int num) {
        return (int) (Math.ceil(num / DEFAULT_SIZE) * DEFAULT_SIZE);

    }

    public Iterator<T> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<T> {
        private int index;
        private List2<T> items;

        ListIterator(List2<T> items) {
            this.index = 0;
            this.items = items;
        }

        public boolean hasNext() {
            return index < items.size();
        }

        public T next() {
            return items.get(index++);
        }
        

    }
    
}
