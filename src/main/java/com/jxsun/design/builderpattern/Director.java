package com.jxsun.design.builderpattern;

/**
 * Created by sunjx on 2017/11/7.
 */
public class Director {

    private Builder builder = new ConcreteBuilder();

    public Product buildProductA(){
        Product product = builder.build();
        builder.setPart("bmw" ,"001");
        return product;
    }
}
