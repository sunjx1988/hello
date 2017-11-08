package com.jxsun.design.criteriapattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjx on 2017/11/8.
 */
public class Run {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("white",10));
        personList.add(new Person("black",10));
        personList.add(new Person("yellow",10));
        personList.add(new Person("white",11));
        personList.add(new Person("black",18));
        personList.add(new Person("yellow",28));

        Criteria ageCriteria = new AgeCriteria(10);
        Criteria skinCriteria = new SkinColorCriteria("yellow");
        Criteria andCriteria = new AndCriteria(ageCriteria , skinCriteria);
        Criteria orCriteria = new OrCriteria(ageCriteria, skinCriteria);

        System.out.println("age=10");
        print(ageCriteria.criteria(personList));

        System.out.println("skin=yellow");
        print(skinCriteria.criteria(personList));

        System.out.println("age=10 and skin=yellow");
        print(andCriteria.criteria(personList));

        System.out.println("age=10 or skin=yellow");
        print(orCriteria.criteria(personList));


    }

    static void print(List<Person> people){
        for (Person person : people){
            System.out.println(person);
        }
    }
}
