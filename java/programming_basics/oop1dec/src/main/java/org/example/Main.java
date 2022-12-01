package org.example;

public class Main {
    public static void main(String[] args) {

        // when we make class Bird abstract we cant create instance of it like this:
//        Bird bird = new Bird();
//        bird.fly();

//        Parrot parrot1 = new Parrot();
//        parrot1.fly();

//        System.out.println(parrot1 instanceof Parrot); // true
//        System.out.println(parrot1 instanceof Bird); // true
//        System.out.println(parrot1 instanceof Object); // true

//        parrot1.speak();
//        parrot1.name = "Klyopa";
//        parrot1.speak();
//        parrot1.setName("Klyopa");
//        System.out.println(parrot1.getName());
//        parrot1.speak();
//        Penguin penguin1  = new Penguin("Gosha");
//        parrot2.speak();
//
//        parrot2 = parrot1;
//        parrot2.speak();

//        Penguin penguin1 = new Penguin();
//        penguin1.fly();

//        Penguin penguin2 = new Penguin("Tolya");
//        Bird[] birds = new Bird[]{parrot1,penguin1,penguin2};
//        for (int i = 0; i < parrots.length; i++) {
//            parrots[i].fly();
//        }

//        for(Bird bird : birds){
//            bird.fly();
//            if (bird instanceof Parrot){
//                ((Parrot)bird).speak();
//            }
//        }
//        penguin1.hello(penguin2);

        Parrot p1 = new Parrot("Stas");
        Penguin p2 = new Penguin("Kolya");
        Parrot p3 = new Parrot("Petya");

        Parrot p4 = new Parrot("Vlad");
        Penguin p5 = new Penguin("Nikita");
        Parrot p6 = new Parrot("Kirill");

        BirdsTeam bt1 = new BirdsTeam(new Bird[]{p1,p2,p3}, p1);

        BirdsTeam bt2 = new BirdsTeam(new Bird[]{p4,p5,p6}, p4);
        bt1.print();
        bt2.print();
        System.out.println("team 1 leader name " + bt1.getLeader().getName());
        System.out.println("team 2 leader name " + bt2.getLeader().getName());
        System.out.println();
        bt1.add(bt2);
        System.out.println("after adding team:");
        bt1.print();
    }
}