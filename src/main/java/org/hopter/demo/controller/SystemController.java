package org.hopter.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.hopter.framework.annotation.Action;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.bean.Param;
import org.hopter.framework.bean.View;
import org.hopter.framework.enums.RequestMethod;
import org.hopter.plugin.security.SecurityHelper;
import org.hopter.plugin.security.annotation.User;
import org.hopter.plugin.security.exception.AuthcException;

/**
 * 处理系统请求
 *
 * @author Angus
 * @date 2018/12/9
 */
@Slf4j
@Controller
public class SystemController {

    /**
     * 进入首界面
     */
    @Action(method = RequestMethod.GET, path = "/")
    public View index() {
        return new View("index.jsp");
    }

    /**
     * 进入登录界面
     */
    @Action(method = RequestMethod.GET, path = "/login")
    public View login() {
        return new View("login.jsp");
    }

    /**
     * 提交登录表单
     */
    @Action(method = RequestMethod.POST, path = "/login")
    public View loginSubmit(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");
        try {
            SecurityHelper.login(username, password);
        } catch (AuthcException e) {
            log.error("login failure", e);
            return new View("/login");
        }
        return new View("/customer");
    }

    /**
     * 提交注销请求
     */
    @Action(method = RequestMethod.GET, path = "/logout")
    public View logout() {
        SecurityHelper.logout();
        return new View("/");
    }
}
