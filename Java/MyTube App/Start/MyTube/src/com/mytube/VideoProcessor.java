package com.mytube;

public class VideoProcessor {
    
    private Encodeable encodeable;
    private Storeable storeable;
    private Notifyable notifyable;

    VideoProcessor(Encodeable encodeable, Storeable storeable, Notifyable notifyable) {
        this.encodeable = encodeable;
        this.storeable = storeable;
        this.notifyable = notifyable;

    }

    public void process(Video video) {
        encodeable.encode(video);
        storeable.store(video);
        notifyable.sendNotification(video.getUser().getEmail());
    }
}

