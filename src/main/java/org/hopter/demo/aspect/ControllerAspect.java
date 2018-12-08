package org.hopter.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.hopter.framework.annotation.Aspect;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * @author Angus
 * @date 2018/12/3
 */
@Slf4j
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        if (!"toString".equals(method.getName()) && !"hashCode".equals(method.getName())) {
            log.info("Controller -> {}.{}", cls.getName(), method.getName());
        }
    }
}
