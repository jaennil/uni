import java.awt.*;

public class Cell {
    public static int SIZE;
    private boolean alive;
    public int i, j;
    private Color color;

    public Cell(int i, int j, boolean alive) {
        this.i = i;
        this.j = j;
        this.alive = alive;
        updateColor();
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return alive == false;
    }

    public Color getColor() {
        return color;
    }

    public void setAlive() {
        alive = true;
        updateColor();
    }

    public void setDead() {
        alive = false;
        updateColor();
    }

    public void updateColor() {
        color = alive ? Color.BLACK : Color.WHITE;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.j * SIZE + 40, this.i * SIZE + 50, SIZE, SIZE);
    }
}