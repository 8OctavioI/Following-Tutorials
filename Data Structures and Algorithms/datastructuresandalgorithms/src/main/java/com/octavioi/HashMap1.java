package com.octavioi;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap1<T1, T2> {
    private static final int MAX_SIZE = 10;
    private ArrayList<LinkedList<Entry<T1, T2>>> entries;

    HashMap1(int capacity) {
        this.entries = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.entries.add(null);
        }
    }

    private int hash(T1 key) {
        return key.hashCode() % MAX_SIZE;

    }

    public void put(T1 key, T2 value) {
        int key2 = hash(key);

        if (entries.get(key2) == null) {
            LinkedList<Entry<T1, T2>> entry = new LinkedList<>();
            entry.add(new Entry<T1, T2>(key, value));
            entries.set(key2, entry);
        } else {
            entries.get(key2).add(new Entry<T1, T2>(key, value));
        }
    }

    public T2 get(T1 key) {
        int key2 = hash(key);
        var list = entries.get(key2);
        for (var item : list) {
            if (item.getKey() == key)
                return item.getValue();
        }
        return null;
    }

    public void remove(T1 key) {
        int key2 = hash(key);
        var list = entries.get(key2);
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getKey() == key) {
                list.remove(index);
                return;
            }
        }
    }

    @Override
    public String toString() {
        String res = "Start:\n";
        for (var item : entries) {
            if (item != null) {
                for (var entry : item) {
                    res += entry.getValue() + ", ";
                }
                res += "\n";
            }
        }
        return res + "\nEnd";
    }

    private class Entry<T1, T2> {
        T1 key;

        T2 value;

        Entry(T1 key, T2 value) {
            this.key = key;
            this.value = value;
        }

        public T1 getKey() {
            return key;
        }

        public T2 getValue() {
            return value;
        }

        public void setValue(T2 value) {
            this.value = value;
        }
    }
}