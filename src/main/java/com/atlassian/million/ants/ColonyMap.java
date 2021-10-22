package com.atlassian.million.ants;

import javax.swing.*;
import java.awt.*;

public class ColonyMap extends JPanel {

    private final Colony colony;

    public ColonyMap(Colony colony) {
        this.colony = colony;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        colony.listAnts().forEach(ant -> ant.paint(g));
    }
}
