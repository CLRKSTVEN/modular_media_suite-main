package com.example.media.proxy;

import com.example.media.source.MediaSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple in-memory caching proxy for remote media sources.
 */
public class RemoteProxySource implements MediaSource {
    private final MediaSource remote;
    private static final Map<String,String> cache = new HashMap<>();

    public RemoteProxySource(MediaSource remote) {
        this.remote = remote;
    }

    @Override
    public String getId() {
        return "proxy:" + remote.getId();
    }

    @Override
    public String openStream() {
        String id = remote.getId();
        if (cache.containsKey(id)) {
            System.out.println("[RemoteProxySource] Cache HIT for " + id);
            return cache.get(id);
        } else {
            System.out.println("[RemoteProxySource] Cache MISS for " + id + ". Fetching...");
            String token = remote.openStream();
            String cachedToken = token + ":cached";
            cache.put(id, cachedToken);
            return cachedToken;
        }
    }
}
