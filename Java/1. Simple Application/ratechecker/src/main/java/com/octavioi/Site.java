package com.octavioi;

import java.util.concurrent.CompletableFuture;
import java.util.function.*;


public class Site implements RateRetrievable{
    private String name;
    private Supplier<Integer> randomPrice = () -> (int) (100 + (Math.random() * 10));
    private Consumer<Integer> waitTime = (time) -> {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    Site(int num) {
        name = "Site[" + num + "]";
    }

    @Override
    public Packet retrieve() {
        System.out.println("Reading from: " + name);
        waitTime.accept(1000 * (randomPrice.get() - 100));
        return new Packet(name, randomPrice.get());
    }

    @Override
    public CompletableFuture<Packet> retrieveAsync() {
        return CompletableFuture.supplyAsync(() -> retrieve());
    }
}
