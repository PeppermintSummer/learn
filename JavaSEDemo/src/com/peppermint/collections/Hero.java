package com.peppermint.collections;

/**
 * @author Administrator
 */
public class Hero implements Comparable<Hero> {
    private String name;

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Hero o) {
        return 1;
    }
}
