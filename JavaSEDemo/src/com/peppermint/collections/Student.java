package com.peppermint.collections;

public class Student {
    public String name;
    public String course;
    public int score;
    public int total;
    public Student() {}

    public Student(String name, String course, int score) {
        this.name = name;
        this.course = course;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
