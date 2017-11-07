package com.jxsun.design.builderpattern;

/**
 * Created by sunjx on 2017/11/7.
 */
public class Run {
    public static void main(String[] args) {
        Director director = new Director();
        Product productA = director.buildProductA();
        System.out.println(productA);
    }
}
