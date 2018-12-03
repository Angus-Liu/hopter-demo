package org.hopter.demo.service;

import org.hopter.framework.annotation.Service;

/**
 * @author Angus
 * @date 2018/12/1
 */
@Service
public class DemoService {
    public String getSomething() {
        return "demo: service get something!";
    }

    public String postSomething() {
        return "demo: service post something!";
    }
}
