package com.jxsun.design.criteriapattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjx on 2017/11/8.
 */
public class SkinColorCriteria implements Criteria {

    private String skinColor;

    public SkinColorCriteria(String skinColor){
        this.skinColor = skinColor;
    }

    @Override
    public List<Person> criteria(List<Person> list) {
        List<Person> result = new ArrayList<>();

        for (Person person : list){
            if (person.getSkinColor().equals(skinColor)){
                result.add(person);
            }
        }
        return result;
    }
}
