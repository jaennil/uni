import javax.swing.*;
import java.awt.*;

public class Cell {
    public static int SIZE;
    private boolean alive;
    public int i, j;
    private Color color;
    protected JButton button;

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
        return !alive;
    }

    public Color getColor() {
        return color;
    }

    public void setAlive() {
        this.alive = true;
        updateColor();
    }

    public void setDead() {
        this.alive = false;
        updateColor();
    }

    public void updateColor() {
        if (alive) {
            color = Color.BLACK;
        } else {
            color = Color.WHITE;
        }
        if (button != null) {
            button.setBackground(color);
        }
    }

    public void draw(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.i * SIZE + 40, this.j * SIZE + 50, SIZE, SIZE);
    }
}