package com.jxsun.design.builderpattern;

/**
 * Created by sunjx on 2017/11/7.
 */
public class Product {

    private String type;

    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
