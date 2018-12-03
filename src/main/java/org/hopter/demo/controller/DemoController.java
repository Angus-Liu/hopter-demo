package org.hopter.demo.controller;

import org.hopter.demo.service.DemoService;
import org.hopter.framework.annotation.Action;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.annotation.Inject;
import org.hopter.framework.bean.Data;
import org.hopter.framework.bean.Param;
import org.hopter.framework.enums.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Angus
 * @date 2018/12/1
 */
@Controller
public class DemoController {

    @Inject
    private DemoService service;

    @Action(method = RequestMethod.GET, path = "/demo")
    public Data getData(Param param) {
        Map<String, String> map = new HashMap<>();
        String something = service.getSomething();
        map.put("get", something);
        return new Data(map);
    }

    @Action(method = RequestMethod.POST, path = "/demo")
    public Data postData(Param param) {
        Map<String, String> map = new HashMap<>();
        String something = service.postSomething();
        map.put("post", something);
        return new Data(map);
    }
}
