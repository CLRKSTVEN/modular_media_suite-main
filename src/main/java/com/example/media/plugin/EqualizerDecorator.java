package com.example.media.plugin;

import com.example.media.player.Renderer;

public class EqualizerDecorator extends RendererDecorator {
    private final String preset;

    public EqualizerDecorator(Renderer wrapped, String preset) {
        super(wrapped);
        this.preset = preset;
    }

    @Override
    public void render(String streamToken) {
        System.out.println("[EqualizerDecorator] Applying EQ preset: " + preset);
        super.render(streamToken);
    }
}
