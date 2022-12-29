public class Main {
    public static void main(String[] args) {

        Parrot p1 = new Parrot("Stas");
        Penguin p2 = new Penguin("Kolya");
        Parrot p3 = new Parrot("Petya");
        BirdsTeam bt1 = new BirdsTeam(new Bird[]{p1,p2,p3}, p1);
        Scene scene = new Scene(bt1);
    }
}