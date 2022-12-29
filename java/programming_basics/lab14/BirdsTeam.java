import java.awt.*;

public class BirdsTeam {
    private Bird[] team;
    private Bird leader;
    public BirdsTeam(Bird[] team, Bird leader){
        this.team = team;
        this.leader = leader;
    }

    public void print(){
        for (Bird bird: team) {
            System.out.println(bird.getName());
        }
    }

    public void setLeader(Bird leader){
        this.leader = leader;
    }

    public Bird getLeader(){
        return leader;
    }

    public void add(BirdsTeam bt){
        Bird[] sTeam = new Bird[team.length];
        System.arraycopy(team, 0, sTeam, 0, sTeam.length);
        team = new Bird[team.length + bt.team.length];

        for (int i = 0; i < sTeam.length; i++) {
            team[i] = sTeam[i];
        }
        for (int i = 0; i < bt.team.length; i++) {
            team[i+sTeam.length] = bt.team[i];
        }

        bt.team = null;
    }

    public void draw(Graphics graphics) {
        for (Bird bird: team) {
            bird.draw(graphics);
        }
    }

}