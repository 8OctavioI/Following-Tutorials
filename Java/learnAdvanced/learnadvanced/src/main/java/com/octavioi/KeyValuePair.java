package com.octavioi;

public class KeyValuePair <K, V> {
    private K key;
    private V value;

    KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
