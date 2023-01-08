import javax.swing.*;
import java.awt.*;

public class Cell {
    public static final int SIZE = 20;
    protected final int x, y;
    private boolean isAlive;
    private Color color;
    protected JButton button;

    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
        updateColor();
        createButton();
    }

    private void createButton() {
        button = new JButton();
        button.setBounds(x * SIZE + 40, y * SIZE + 50, SIZE, SIZE);
        button.setBackground(color);
    }
    public boolean isAlive() {
        return isAlive;
    }

    public Color getColor() {
        return color;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
        updateColor();
    }

    public void updateColor() {
        if (isAlive) {
            color = Color.BLACK;
        } else {
            color = Color.WHITE;
        }
        if (button != null) {
            button.setBackground(color);
        }
    }
}