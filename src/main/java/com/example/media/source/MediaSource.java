package com.example.media.source;

/**
 * Uniform interface for media sources.
 */
public interface MediaSource {
    String getId();
    String openStream();
}
