package com.atlassian.million.ants;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        var colony = new Colony();


        var w = 1200;
        var h = 1200;
        var frame = new JFrame();
        frame.setLocation(200, 200);
        frame.setPreferredSize(new Dimension(w, h));
        frame.setSize(new Dimension(w, h));
        frame.pack();
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        var map = new ColonyMap(colony);
        map.setVisible(true);
        map.setPreferredSize(new Dimension(w, h));
        map.setFocusable(true);
        map.setBackground(Color.black);

        frame.add(map);
        frame.pack();
        frame.setVisible(true);

        colony.spawnAnts();
        map.startRendering();
    }
}
