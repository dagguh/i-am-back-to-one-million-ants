package com.atlassian.million.ants;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class ColonyMap extends JPanel {

    private static final int TARGET_FPS = 60;
    public static final Duration FRAME_TIME = Duration.ofSeconds(1).dividedBy(TARGET_FPS);
    private final Colony colony;

    public ColonyMap(Colony colony) {
        this.colony = colony;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        colony.listAnts().forEach(ant -> ant.paint(g));
    }

    public void startRendering() {
        var executor = newScheduledThreadPool(1, Thread.ofVirtual().factory());
        executor.scheduleAtFixedRate(
                this::repaint,
                0,
                FRAME_TIME.toMillis(),
                TimeUnit.MILLISECONDS
        );
    }
}
