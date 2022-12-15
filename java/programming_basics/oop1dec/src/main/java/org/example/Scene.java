package org.example;

import javax.swing.*;
import java.awt.*;

public class Scene extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    private BirdsTeam team;

    public Scene(BirdsTeam team) {
        this.team = team;
        setSize(WIDTH, HEIGHT);
        setTitle("Birds");
        setLocation(200,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics graphics) {
//        graphics.setColor(new Color(255,0,0));
//        graphics.drawLine(50,50,90,90);
//        graphics.drawOval(140, 140, 180, 180);
//        graphics.setColor(Color.ORANGE);
//        graphics.fillOval(220, 220, 80, 80);
        team.draw(graphics);
    }
}
