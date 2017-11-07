package com.jxsun.design.factorypattern.producer;

import com.jxsun.design.factorypattern.factory.AbstractFactory;
import com.jxsun.design.factorypattern.factory.BENZFactory;
import com.jxsun.design.factorypattern.factory.BMWFactory;

/**
 * Created by sunjx on 2017/11/7.
 * 理论上producer也是可以再抽象一遍的，抽象成bmw producer 和 benz producer
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String factory){
        if("BMW_FACTORY".equalsIgnoreCase(factory)){
            return new BMWFactory();
        }else if("BENZ_FACTORY".equalsIgnoreCase(factory)){
            return new BENZFactory();
        }else {
            throw new RuntimeException("create factory fail");
        }
    }
}
