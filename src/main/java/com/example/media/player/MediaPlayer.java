package com.example.media.player;

import com.example.media.source.MediaSource;

/**
 * Abstraction (Bridge). Holds a reference to a Renderer implementor.
 */
public abstract class MediaPlayer {
    protected Renderer renderer; // implementor

    public MediaPlayer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setRenderer(Renderer renderer) {
        System.out.println("[MediaPlayer] Switching renderer -> " + renderer.getClass().getSimpleName());
        this.renderer = renderer;
    }

    // high-level operation: play a MediaSource
    public abstract void playSource(MediaSource source);
}
