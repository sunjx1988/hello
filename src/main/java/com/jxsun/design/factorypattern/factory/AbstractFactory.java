package com.jxsun.design.factorypattern.factory;

import com.jxsun.design.factorypattern.product.Product;

/**
 * Created by sunjx on 2017/11/7.
 * 抽象工厂
 */
public abstract class AbstractFactory {

    public abstract Product getProduct(String name);
}
