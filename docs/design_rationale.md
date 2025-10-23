# Design Rationale

## Goal
Refactor a monolithic media player into a modular suite that supports multiple media sources, runtime renderer switching (via Bridge), on-the-fly plugins, composite playlists, and remote-proxy caching. The focus is separation of concerns and extensibility while using structural design patterns.

## Patterns used and why
Adapter: Wrap legacy sources with an adapter to present a consistent MediaSource interface. This avoids invasive legacy rewrites.
Bridge: Separate the MediaPlayer abstraction from Renderer implementations to allow runtime switching while remaining structural.
Decorator: Compose rendering features (watermark, equalizer) by wrapping Renderer implementations. This prevents combinatorial explosion of renderer subclasses.
Composite: Represent playlists and nested playlists uniformly so the player can traverse them recursively.
Proxy: Cache remote streams transparently, improving performance on repeated plays.

## Trade-offs
The demo simulates playback and uses an in-memory cache. Production would require real media libraries, threading, buffering, eviction policies, and plugin lifecycle management.
