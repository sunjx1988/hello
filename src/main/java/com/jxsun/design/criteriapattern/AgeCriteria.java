package com.jxsun.design.criteriapattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjx on 2017/11/8.
 */
public class AgeCriteria implements Criteria {
    private int age ;

    public AgeCriteria(int age) {
        this.age = age;
    }

    @Override
    public List<Person> criteria(List<Person> list) {
        List<Person> result = new ArrayList<>();

        for (Person person : list){
            if (person.getAge() == age){
                result.add(person);
            }
        }
        return result;
    }
}
