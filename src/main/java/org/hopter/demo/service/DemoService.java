package org.hopter.demo.service;

import org.hopter.framework.annotation.Service;

/**
 * @author Angus
 * @date 2018/12/1
 */
@Service
public class DemoService {
    public String getView() {
        return "demo: service get view!";
    }

    public String redirect() {
        return "demo: service redirect!";
    }
}
