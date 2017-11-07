package com.jxsun.design.factorypattern;

import com.jxsun.design.factorypattern.factory.AbstractFactory;
import com.jxsun.design.factorypattern.producer.FactoryProducer;
import com.jxsun.design.factorypattern.product.Product;

/**
 * Created by sunjx on 2017/11/7.
 */
public class Run {

    public static void main(String[] args) {

        AbstractFactory factory = FactoryProducer.getFactory("BENZ_FACTORY");
        Product product = factory.getProduct("BENZ001");
        product.run();

    }
}
