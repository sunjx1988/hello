package com.jxsun.design.factory;

import com.jxsun.design.product.bmw.BMW001;
import com.jxsun.design.product.bmw.BMW002;
import com.jxsun.design.product.Product;

/**
 * Created by sunjx on 2017/11/7.
 */
public class BMWFactory extends AbstractFactory {
    @Override
    public Product getProduct(String name) {

        if("BMW001".equalsIgnoreCase(name)){
            return new BMW001();
        }else if("BMW002".equalsIgnoreCase(name)){
            return new BMW002();
        }else {
            throw new RuntimeException("create bmw fail");
        }
    }
}
