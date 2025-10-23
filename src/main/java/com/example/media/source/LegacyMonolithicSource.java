package com.example.media.source;

/**
 * Simulated legacy monolithic class (different API).
 */
public class LegacyMonolithicSource {
    private final String descriptor;

    public LegacyMonolithicSource(String descriptor) {
        this.descriptor = descriptor;
    }

    public String fetch() {
        System.out.println("[LegacyMonolithicSource] fetch: " + descriptor);
        return "legacy-stream(" + descriptor + ")";
    }
}
