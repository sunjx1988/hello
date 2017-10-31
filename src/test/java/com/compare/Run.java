package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class Run {

    //排序接口 list 是需要排序的集合， type 是排序类型：1·使用a值排序，2使用b值排序
    List<Vo> sort(List<Vo> list, final int type) {
        List<Vo> result = new ArrayList<Vo>(list.size());

        switch (type) {
            case 1:
                Collections.sort(list, new Comparator<Vo>() {
                    public int compare(Vo o1, Vo o2) {
                        return o1.getA().compareTo(o2.getA());
                    }
                });
                break;

            case 2:
                Collections.sort(list, new Comparator<Vo>() {
                    public int compare(Vo o1, Vo o2) {
                        return o1.getB().compareTo(o2.getB());
                    }
                });
                break;

        }
        return result;
    }


}

class Vo {

    private Long a;

    private Long b;

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }

    public Long getB() {
        return b;
    }

    public void setB(Long b) {
        this.b = b;
    }
}
