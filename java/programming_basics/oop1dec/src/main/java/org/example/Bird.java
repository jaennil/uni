package org.example;

import java.awt.*;

public abstract class Bird {
    private String name;

    private static int count = 0;
    protected int x,y;
    protected int size;
    protected Color color;
    public Bird() {
        count++;
        System.out.println("I'm a bird");
        System.out.println("Birds count: " + count);

        x = (int) (Math.random() * Scene.WIDTH);
        y = (int) (Math.random() * Scene.HEIGHT);

        size = 10;
        // color = Color.BLACK;
        color = new Color(0,0,0);
    }


    public Bird(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println("I'm flying");
    }

    public String getName() {
        return name;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x-size/2, y-size/2, size, size);
    }
}