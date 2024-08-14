package com.mytube;

public class VideoEncoder implements Encodeable{
    public Boolean encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
        return true;
    }
}
