package com.example.media.source;

public class LocalFileSource implements MediaSource {
    private final String path;

    public LocalFileSource(String path) {
        this.path = path;
    }

    @Override
    public String getId() {
        return "local:" + path;
    }

    @Override
    public String openStream() {
        System.out.println("[LocalFileSource] Opening local file: " + path);
        return "stream(local:" + path + ")";
    }
}
