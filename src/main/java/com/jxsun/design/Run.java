package com.jxsun.design;

import com.jxsun.design.factory.AbstractFactory;
import com.jxsun.design.producer.FactoryProducer;
import com.jxsun.design.product.Product;

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
