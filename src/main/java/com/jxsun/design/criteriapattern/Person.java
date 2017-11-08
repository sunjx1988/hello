package com.jxsun.design.criteriapattern;

/**
 * Created by sunjx on 2017/11/8.
 */
public class Person {

    private String skinColor;

    private int age;

    public Person(String skinColor, int age) {
        this.skinColor = skinColor;
        this.age = age;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "skinColor='" + skinColor + '\'' +
                ", age=" + age +
                '}';
    }
}
