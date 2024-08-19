package com.octavioi;

public class Packet {

    private String name;
    private int price;

    Packet(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Output: {Site: %s, Price: %d}", name, price);
    }
};
