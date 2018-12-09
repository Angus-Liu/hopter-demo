package org.hopter.demo.controller;

import org.hopter.demo.service.DemoService;
import org.hopter.framework.annotation.Action;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.annotation.Inject;
import org.hopter.framework.bean.Data;
import org.hopter.framework.bean.Param;
import org.hopter.framework.bean.View;
import org.hopter.framework.enums.RequestMethod;
import org.hopter.framework.helper.ServletHelper;
import org.hopter.plugin.security.annotation.User;

/**
 * @author Angus
 * @date 2018/12/1
 */
@Controller
public class DemoController {

    @Inject
    private DemoService service;

    @Action(method = RequestMethod.GET, path = "/param")
    public Data getParam(Param param) {
        System.out.println(param);
        return new Data(param.getFieldMap());
    }

    @Action(method = RequestMethod.POST, path = "/param")
    public Data postParam(Param param) {
        System.out.println(param);
        return new Data(param.getFieldMap());
    }

    @User
    @Action(method = RequestMethod.GET, path = "/view")
    public View getView() {
        service.getView();
        return new View("hello.jsp");
    }

    @Action(method = RequestMethod.GET, path = "/redirect")
    public View redirect() {
        service.redirect();
        return new View("/test");
    }
}
