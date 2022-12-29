import javax.swing.*;
import java.awt.*;

public class Scene extends JFrame {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
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
        team.draw(graphics);
    }
}