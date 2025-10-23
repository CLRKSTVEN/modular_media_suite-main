package com.example.media.plugin;

import com.example.media.player.Renderer;

public class WatermarkDecorator extends RendererDecorator {
    private final String watermarkText;

    public WatermarkDecorator(Renderer wrapped, String watermarkText) {
        super(wrapped);
        this.watermarkText = watermarkText;
    }

    @Override
    public void render(String streamToken) {
        System.out.println("[WatermarkDecorator] Applying watermark: " + watermarkText);
        super.render(streamToken);
    }
}
