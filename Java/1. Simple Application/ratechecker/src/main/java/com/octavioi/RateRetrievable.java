package com.octavioi;

import java.util.concurrent.CompletableFuture;

public interface RateRetrievable {
    Packet retrieve();
    CompletableFuture<Packet> retrieveAsync();
}
