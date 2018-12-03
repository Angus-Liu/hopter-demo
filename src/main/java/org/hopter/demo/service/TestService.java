package org.hopter.demo.service;

import org.hopter.framework.annotation.Service;
import org.hopter.framework.annotation.Transaction;

/**
 * @author Angus
 * @date 2018/12/1
 */
@Service
public class TestService {
    @Transaction
    public String getSomething() {
        return "test: service get something!";
    }

    public String postSomething() {
        return "test: service post something!";
    }
}
