import java.awt.*;

public class Penguin extends Bird{
    String name;
    private static int count = 0;
    public Penguin(String name){
        count++;
        System.out.println("I'm penguin");
        System.out.println("Penguins count: " + count);
        this.name = name;

        size = 20;

    }

    @Override
    public void fly(){
        System.out.println("I can't fly");
    }

    public String getName(){
        return name;
    }
    public void hello(Penguin penguin){
        System.out.println("hi " + penguin.getName() + " my name is " + name);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.setColor(Color.WHITE);
        graphics.fillOval(x - size/4, y - size/4, size/2, size/2);
    }
}