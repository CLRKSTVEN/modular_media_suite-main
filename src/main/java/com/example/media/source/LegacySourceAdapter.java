package com.example.media.source;

/**
 * Adapter: wrap a legacy source and expose MediaSource.
 */
public class LegacySourceAdapter implements MediaSource {
    private final LegacyMonolithicSource legacy;
    private final String id;

    public LegacySourceAdapter(LegacyMonolithicSource legacy, String id) {
        this.legacy = legacy;
        this.id = id;
    }

    @Override
    public String getId() {
        return "legacy:" + id;
    }

    @Override
    public String openStream() {
        String s = legacy.fetch();
        System.out.println("[LegacySourceAdapter] adapted -> " + s);
        return s;
    }
}
