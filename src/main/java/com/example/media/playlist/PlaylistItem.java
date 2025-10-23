package com.example.media.playlist;

import com.example.media.player.MediaPlayer;

public interface PlaylistItem {
    String getName();
    void play(com.example.media.player.MediaPlayer player);
}
