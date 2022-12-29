import java.awt.*;

public class Parrot extends Bird {

    private static int count = 0;
    private String name = "Kesha";

    public Parrot() {
        System.out.println("I'm a parrot");
    }

    public Parrot(String name) {
        count++;
        this.name = name;
        System.out.println("I'm a parrot");
        System.out.println("Parrots count: " + count);

        color = new Color(0, 255, 0);
    }

    public void speak() {
        System.out.println("hi. I'm " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x - size / 4, y - size / 4, size / 2, size / 2);
        graphics.drawRect(x - size / 4, y - size / 4, size / 2, size / 2);
    }
}