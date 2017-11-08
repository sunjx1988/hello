package com.jxsun.design.criteriapattern;

import java.util.List;

/**
 * Created by sunjx on 2017/11/8.
 * 并且条件
 */
public class AndCriteria implements Criteria{

    private Criteria criteria;

    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> criteria(List<Person> list) {
        return otherCriteria.criteria(criteria.criteria(list));
    }
}
