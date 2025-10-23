package com.example.media.player;

import com.example.media.source.MediaSource;

/**
 * Concrete Abstraction in Bridge: delegates rendering to the implementor.
 */
public class ConcreteMediaPlayer extends MediaPlayer {
    public ConcreteMediaPlayer(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void playSource(MediaSource source) {
        System.out.println("[ConcreteMediaPlayer] Opening source: " + source.getId());
        String token = source.openStream();
        System.out.println("[ConcreteMediaPlayer] Delegating render to implementor");
        renderer.render(token);
        System.out.println("[ConcreteMediaPlayer] Finished playback of " + source.getId());
    }
}
