## Modular Media Streaming Suite (Java)

A simple Java console project that demonstrates how structural design patterns work together in a modular media player.
It simulates video and audio playback using printed console logs.

## Design Patterns Used

Bridge – separates the media player from the renderer (hardware vs software).

Adapter – lets old legacy media sources work with the new player.

Decorator – adds extra features like watermark or equalizer effects.

Composite – allows playlists and even nested playlists to play in sequence.

Proxy – caches remote media for faster access on repeated playback.

## Features

Play media from local files, online streams (HLS), and remote APIs.

Nested playlists supported using the Composite pattern.

Switch between Hardware (GPU) and Software (CPU) renderers anytime.

Add Equalizer and Watermark dynamically using Decorators.

Automatically cache remote media using Proxy.

Play legacy media through Adapter without changing old code.

## How to Run

## Requirements

Java 17 or higher (tested on JDK 25)

Any IDE (VS Code, IntelliJ, Eclipse) with Java support

Run in VS Code

Open the project folder in VS Code.

Install the Java Extension Pack if prompted.

Open Demo.java.

## Click Run or press Ctrl + F5 to execute.

Run in Command Line
mkdir -p out
javac -d out $(find src -name "\*.java")
java -cp out com.example.media.Demo
