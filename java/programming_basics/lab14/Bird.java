import java.awt.*;

public abstract class Bird {
    private String name;
    private int count = 0;
    protected int x, y;
    protected int size;
    protected Color color;

    public Bird() {
        count++;
        System.out.println("I'm a bird");
        System.out.println("Birds count: " + count);
        size = 130;
        x = (int) (Math.random() * (Scene.WIDTH - size*2) + size);
        y = (int) (Math.random() * (Scene.HEIGHT - size*2) + size);
        if (x > Main.max_x) {
            max_x = x;
        }
    }

    public Bird(String name) {
        this.name = name;
    }

    public void fly() {
        System.out.println("I'm flying");
    }

    public String getName() {
        return name;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillOval(x - size / 4, y - size / 4, size / 2, size / 2);
    }
}
