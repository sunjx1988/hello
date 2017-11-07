package com.jxsun.design.factorypattern.factory;

import com.jxsun.design.factorypattern.product.Product;
import com.jxsun.design.factorypattern.product.benz.BENZ001;
import com.jxsun.design.factorypattern.product.benz.BENZ002;

/**
 * Created by sunjx on 2017/11/7.
 */
public class BENZFactory extends AbstractFactory {
    @Override
    public Product getProduct(String name) {
        if("BENZ001".equalsIgnoreCase(name)){
            return new BENZ001();
        }else if("BENZ002".equalsIgnoreCase(name)){
            return new BENZ002();
        }else {
            throw new RuntimeException("create benz fail");
        }
    }
}
