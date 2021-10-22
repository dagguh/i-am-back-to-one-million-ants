package com.atlassian.million.ants;

import java.awt.*;
import java.util.Random;

public class Ant {

    private final Random rng = new Random();
    private final Point position = new Point(rng.nextInt(640), rng.nextInt(640));
    private final Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));

    public void paint(Graphics g) {
        g.setColor(color);
        g.drawOval(position.x, position.y, 2, 2);
    }
}
