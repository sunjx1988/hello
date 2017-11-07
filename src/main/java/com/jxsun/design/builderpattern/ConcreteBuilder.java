package com.jxsun.design.builderpattern;

/**
 * Created by sunjx on 2017/11/7.
 */
public class ConcreteBuilder extends Builder{
    private Product product ;

    @Override
    public Product build() {
        product = new Product();
        return product;
    }

    @Override
    public void setPart(String type, String name) {
        product.setType(type);
        product.setName(name);
    }
}
