package org.example;

public class Parrot extends Bird{

    private String name = "Kesha";
    public Parrot(){
        System.out.println("I'm a parrot");
    }

    public Parrot(String name){
        this.name = name;
        System.out.println("I'm a parrot");
    }

    public void speak(){
        System.out.println("hi. I'm " + name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
