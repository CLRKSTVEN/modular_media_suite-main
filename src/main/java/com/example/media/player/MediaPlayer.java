package com.example.media.player;

import com.example.media.source.MediaSource;


public abstract class MediaPlayer {
    protected Renderer renderer;

    public MediaPlayer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setRenderer(Renderer renderer) {
        System.out.println("[MediaPlayer] Switching renderer -> " + renderer.getClass().getSimpleName());
        this.renderer = renderer;
    }

    public abstract void playSource(MediaSource source);
}
