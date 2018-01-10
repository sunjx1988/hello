package com.framework.controller;

import com.framework.annotation.Action;
import com.framework.annotation.Controller;
import com.framework.annotation.Inject;
import com.framework.service.UserService;

/**
 * Created by sunjx on 2018/1/10.
 */
@Controller
public class IndexController {

    @Inject
    private UserService userService;

    @Action("GET:/abc")
    public void getAbc(){

    }
}
