import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final Field field;
    public Window(Field field) {
        this.field = field;
        init();
    }
    private void init() {
        int x = 3200;
        int y = 2000;
        setBounds(x, y, WIDTH, HEIGHT);
        setTitle("Game of life");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics graphics) {
        // super.paint(graphics);
        for (Cell[] row : field.cells) {
            for (Cell cell : row) {
                cell.draw(graphics);
            }
        }
        repaint();
    }
}