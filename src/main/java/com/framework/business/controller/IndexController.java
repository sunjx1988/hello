package com.framework.business.controller;

import com.framework.annotation.Action;
import com.framework.annotation.Controller;
import com.framework.bean.View;

/**
 * Created by sunjx on 2018/1/10.
 */
@Controller
public class IndexController {

    @Action("GET:/")
    public View index(){
        return new View("index.jsp");
    }
}
