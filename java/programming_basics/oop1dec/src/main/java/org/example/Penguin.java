package org.example;

public class Penguin extends Bird{
    String name;
    public Penguin(String name){
        System.out.println("I'm penguin");
        this.name = name;
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
}
