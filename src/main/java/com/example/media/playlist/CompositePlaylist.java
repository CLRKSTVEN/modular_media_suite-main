package com.example.media.playlist;

import com.example.media.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

public class CompositePlaylist implements PlaylistItem {
    private final String name;
    private final List<PlaylistItem> items = new ArrayList<>();

    public CompositePlaylist(String name) {
        this.name = name;
    }

    public void add(PlaylistItem item) {
        items.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play(MediaPlayer player) {
        System.out.println("[CompositePlaylist] Playing playlist: " + name);
        for (PlaylistItem item : items) {
            item.play(player);
        }
    }
}
