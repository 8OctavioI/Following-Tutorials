package com.octavioi;

import java.util.Iterator;

public class List <T> {
    private T[] items;
    private int count;
    private int MaxIndex;

    List() {
        this(5);
    }

    List(Integer num){
        MaxIndex = closest10Multiple(num) - 1;
        items = (T[]) new Object[MaxIndex + 1];
        for (count = 0; count < num; count++) {
            items[count] = null;
        }
        count = 0;
    }

    List(T[] items) {
        this.MaxIndex = closest10Multiple(items.length) - 1;
        this.items = (T[]) new Object[MaxIndex + 1];
        count = 0;
        for (T item : items) {
            this.items[count++] = item;
        }
    }

    private int closest10Multiple(int num) {
        return (int) Math.ceil(num / 10D) * 10;

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
        for (int i = 0; i < count; i++) {
            res += this.items[i].toString() + ", ";
        }
        res += "]";
        return res;

    }

    
}
