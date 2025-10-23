package com.example.media;

import com.example.media.player.*;
import com.example.media.playlist.*;
import com.example.media.plugin.*;
import com.example.media.proxy.RemoteProxySource;
import com.example.media.source.*;

public class Demo {

    private static Renderer decorate(Renderer base, String eqPreset, String watermarkText) {
        return new WatermarkDecorator(
                new EqualizerDecorator(base, eqPreset),
                watermarkText
        );
    }

    public static void main(String[] args) {

        Renderer hw = new HardwareRenderer();
        Renderer sw = new SoftwareRenderer();

        MediaPlayer player = new ConcreteMediaPlayer(hw);
        System.out.println("\n=== 0. Setup (Bridge) ===");
        System.out.println("Player starts with HardwareRenderer (GPU).");

        MediaSource local = new LocalFileSource("movie.mp4");
        MediaSource hls = new HlsSource("https://example.com/stream.m3u8");
        MediaSource remote = new RemoteApiSource("https://api.example.com/media/123");
        MediaSource cachedRemote = new RemoteProxySource(remote);

        LegacyMonolithicSource legacyRaw = new LegacyMonolithicSource("old-disk:track-7");
        MediaSource adapted = new LegacySourceAdapter(legacyRaw, "track-7");

        CompositePlaylist root = new CompositePlaylist("Root Playlist");
        root.add(new MediaFile("Local Movie", local));

        CompositePlaylist sub = new CompositePlaylist("Stream Playlist");
        sub.add(new MediaFile("HLS Live", hls));
        sub.add(new MediaFile("Cached Remote", cachedRemote));
        root.add(sub);

        root.add(new MediaFile("Legacy Track (adapted)", adapted));

        System.out.println("\n=== 1. Play playlist with HardwareRenderer (Bridge + Composite) ===");
        root.play(player);

        System.out.println("\n=== 2. Apply decorators: Watermark + Equalizer (Decorator) ===");
        Renderer decoratedHw = decorate(hw, "BassBoost", "SAMPLE-WM");

        player.setRenderer(decoratedHw);

        player.playSource(cachedRemote);

        System.out.println("\n=== 3. Play cached remote stream again (Proxy cache hit) ===");
        player.playSource(cachedRemote);

        System.out.println("\n=== 4. Switch to SoftwareRenderer (Bridge) ===");
        Renderer decoratedSw = decorate(sw, "BassBoost", "SAMPLE-WM");

        player.setRenderer(decoratedSw);
        player.playSource(local);

        System.out.println("\n=== Demo finished ===");
    }
}
