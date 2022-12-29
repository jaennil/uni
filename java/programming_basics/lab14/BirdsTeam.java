import java.awt.*;

public class BirdsTeam {
    private Bird[] team;
    private Bird leader;

    public BirdsTeam(Bird[] team, Bird leader) {
        this.team = team;
        this.leader = leader;
    }

    public void print() {
        for (Bird bird : team) {
            System.out.println(bird.getName());
        }
    }

    public void setLeader(Bird leader) {
        this.leader = leader;
    }

    public Bird getLeader() {
        return leader;
    }

    public void add(BirdsTeam bt) {
        Bird[] sTeam = new Bird[team.length];
        System.arraycopy(team, 0, sTeam, 0, sTeam.length);
        team = new Bird[team.length + bt.team.length];

        for (int i = 0; i < sTeam.length; i++) {
            team[i] = sTeam[i];
        }
        for (int i = 0; i < bt.team.length; i++) {
            team[i + sTeam.length] = bt.team[i];
        }

        bt.team = null;
    }

    public int getMinX() {
        int min = Integer.MAX_VALUE;
        for (Bird bird : team) {
            if (bird.x < min) {
                min = bird.x;
            }
        }
        return min;
    }

    public int getMinY() {
        int min = Integer.MAX_VALUE;
        for (Bird bird : team) {
            if (bird.y < min) {
                min = bird.y;
            }
        }
        return min;
    }

    public int getMaxX() {
        int max = Integer.MIN_VALUE;
        for (Bird bird : team) {
            if (bird.x > max) {
                max = bird.x;
            }
        }
        return max;
    }

    public int getMaxY() {
        int max = Integer.MIN_VALUE;
        for (Bird bird : team) {
            if (bird.y > max) {
                max = bird.y;
            }
        }
        return max;
    }

    public void draw(Graphics graphics) {
        for (Bird bird : team) {
            bird.draw(graphics);
        }
        graphics.setColor(Color.ORANGE);
        graphics.drawRect(getMinX(), getMinY(), getMaxX() - getMinX(), getMaxY() - getMinY());
    }

}