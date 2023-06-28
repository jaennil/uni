import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(Field field) {
        add(field, BorderLayout.CENTER);
        setSize(Field.WIDTH, Field.HEIGHT);
        setTitle("Game of life");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}