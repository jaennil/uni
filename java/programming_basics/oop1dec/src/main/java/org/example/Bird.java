package org.example;

public abstract class Bird {
    private String name;
    public Bird(){
        System.out.println("I'm a bird");
    }

    public Bird(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println("I'm flying");
    }

    public String getName() {
        return name;
    }
}
