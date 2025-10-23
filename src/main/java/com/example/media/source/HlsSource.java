package com.example.media.source;

public class HlsSource implements MediaSource {
    private final String playlistUrl;

    public HlsSource(String playlistUrl) {
        this.playlistUrl = playlistUrl;
    }

    @Override
    public String getId() {
        return "hls:" + playlistUrl;
    }

    @Override
    public String openStream() {
        System.out.println("[HlsSource] Accessing HLS playlist: " + playlistUrl);
        return "stream(hls:" + playlistUrl + ")";
    }
}
