package com.example.media.player;

/**
 * Implementor interface for Bridge. Concrete renderers implement rendering details.
 */
public interface Renderer {
    void render(String streamToken);
}
