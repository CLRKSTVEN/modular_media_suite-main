package com.example.media.player;

public class HardwareRenderer implements Renderer {
    @Override
    public void render(String streamToken) {
        System.out.println("[HardwareRenderer] Rendering with GPU/hardware acceleration: " + streamToken);
        // simulate some work (no real rendering)
    }
}
