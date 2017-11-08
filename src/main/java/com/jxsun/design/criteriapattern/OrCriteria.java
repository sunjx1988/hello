package com.jxsun.design.criteriapattern;

import java.util.List;

/**
 * Created by sunjx on 2017/11/8.
 * 或者条件
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;

    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> criteria(List<Person> list) {
        List<Person> list1 = criteria.criteria(list);
        List<Person> list2 = otherCriteria.criteria(list);

        for (Person person : list1){
            if(!list2.contains(person)){
                list2.add(person);
            }
        }

        return list2;
    }
}
