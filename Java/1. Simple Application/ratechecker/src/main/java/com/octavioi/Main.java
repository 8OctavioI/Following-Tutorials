package com.octavioi;


public class Main {
    public static void main(String[] args) {
        RateRetrievable site1 = new Site(1);
        RateRetrievable site2 = new Site(2);
        RateRetrievable site3 = new Site(3);

        site1
            .retrieveAsync()
            .thenAccept(System.out::println);
        site2
            .retrieveAsync()
            .thenAccept(System.out::println);
        site3
            .retrieveAsync()
            .thenAccept(System.out::println);
            
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}