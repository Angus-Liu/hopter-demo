package org.hopter.demo.controller;

import org.hopter.demo.service.DemoService;
import org.hopter.framework.annotation.Action;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.annotation.Inject;
import org.hopter.framework.bean.Param;
import org.hopter.framework.bean.View;
import org.hopter.framework.enums.RequestMethod;

/**
 * @author Angus
 * @date 2018/12/1
 */
@Controller
public class DemoController {

    @Inject
    private DemoService service;

    @Action(method = RequestMethod.GET, path = "/view")
    public View getView(Param param) {
        service.getView();
        return new View("hello.jsp");
    }

    @Action(method = RequestMethod.GET, path = "/redirect")
    public View redirect(Param param) {
        service.redirect();
        return new View("/test");
    }
}
