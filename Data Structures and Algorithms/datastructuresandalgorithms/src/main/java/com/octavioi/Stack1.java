package com.octavioi;

public class Stack1<T> extends List2<T> {
    
    public void push(T item) {
        add(item);
    }

    public T peek() {
        return this.items[size() - 1];
    }

    public T pop() {
        T temp = peek();
        this.remove(peek());
        return temp;
    }
}
