package com.jxsun.design.criteriapattern;

import java.util.List;

/**
 * Created by sunjx on 2017/11/8.
 */
public interface Criteria {

    List<Person> criteria(List<Person> list);
}
