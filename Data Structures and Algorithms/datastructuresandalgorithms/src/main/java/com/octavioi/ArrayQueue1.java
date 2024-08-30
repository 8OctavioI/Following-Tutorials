package com.octavioi;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayQueue1<T>{
    private T[] items;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    ArrayQueue1(int count) {
        this.capacity = count;
        this.items = (T[]) new Object[count];
        this.count = 0;
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(T item) {
        if (count == items.length)
            throw new IllegalStateException();
        this.items[rear++ % capacity] = item;
        count++;
    }

    public T peek() {
        return items[front % capacity];
    }

    public T deque() {
        T item = items[front % capacity];
        items[front++ % capacity] = null;
        count--;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.asList(items).toString();

    }
    
}