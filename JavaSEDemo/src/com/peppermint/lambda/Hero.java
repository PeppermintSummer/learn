package com.peppermint.lambda;

public class Hero implements Comparable<Hero>{
    public String name;
    public float hp;
    public int damage;

    public Hero(){

    }
    public Hero(String name){
        this.name=name;
    }

    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    @Override
    public int compareTo(Hero o) {
        if (damage<o.damage){
            return 1;
        } else {
            return -1;
        }
    }
}
