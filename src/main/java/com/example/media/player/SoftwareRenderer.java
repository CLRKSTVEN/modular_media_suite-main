package com.example.media.player;

public class SoftwareRenderer implements Renderer {
    @Override
    public void render(String streamToken) {
        System.out.println("[SoftwareRenderer] Rendering in software (CPU): " + streamToken);
    }
}
