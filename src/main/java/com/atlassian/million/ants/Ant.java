package com.atlassian.million.ants;

import java.awt.*;
import java.time.Duration;
import java.util.Random;

public class Ant {

    private final Random rng = new Random();
    private final Point position = new Point(rng.nextInt(1200), rng.nextInt(1200));
    private Color color = new Color(0, rng.nextInt(128), rng.nextInt(128));
    private boolean alive = true;

    public void live() {
        while (alive) {
            try {
                behave();
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
    }

    private void behave() throws InterruptedException {
        var nextBehavior = rng.nextInt(1000);
        if (nextBehavior < 700) {
            walk();
        } else if (nextBehavior < 998) {
            eat();
        } else {
            die();
        }
    }

    private void walk() throws InterruptedException {
        position.translate(step(), step());
        Thread.sleep(Duration.ofMillis(1087));
    }

    private int step() {
        return rng.nextInt(-2, 3);
    }

    private void eat() throws InterruptedException {
        color = color.darker();
        Thread.sleep(Duration.ofMillis(5003));
    }

    private void die() {
        alive = false;
        color = Color.red;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x, position.y, 1, 1);
    }
}
