import java.awt.*;

public class Cell {
    private int x;
    private int y;
    private boolean isAlive;

    private Color color;

    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
        updateColor();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void updateColor() {
        if (isAlive) {
            color = Color.BLACK;
        } else {
            color = Color.WHITE;
        }
    }

    public String toString() {
        return "Cell at (" + x + ", " + y + ") is " + (isAlive ? "alive" : "dead");
    }

    public void draw(Graphics graphics) {
        graphics.drawRect(x, y, Field.CELL_SIZE, Field.CELL_SIZE);
    }


}
