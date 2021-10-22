package com.atlassian.million.ants;

import java.awt.*;
import java.time.Duration;
import java.util.Random;

public class Ant {

    private static final Duration WALK_TIME = ColonyMap.FRAME_TIME;
    private final Random rng = new Random();
    private final Point position = new Point(rng.nextInt(1200), rng.nextInt(1200));
    private final Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));

    public void walk() {
        while (true) {
            position.translate(step(), step());
            try {
                Thread.sleep(WALK_TIME);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
    }

    private int step() {
        return rng.nextInt(-2, 3);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x, position.y, 1, 1);
    }
}
