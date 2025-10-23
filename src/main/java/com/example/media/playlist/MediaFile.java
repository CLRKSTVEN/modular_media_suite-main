package com.example.media.playlist;

import com.example.media.player.MediaPlayer;
import com.example.media.source.MediaSource;

public class MediaFile implements PlaylistItem {
    private final String name;
    private final MediaSource source;

    public MediaFile(String name, MediaSource source) {
        this.name = name;
        this.source = source;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play(MediaPlayer player) {
        System.out.println("[Playlist] Playing file: " + name);
        player.playSource(source);
    }
}
