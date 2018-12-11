package org.hopter.demo.controller;

import org.hopter.demo.model.Customer;
import org.hopter.demo.service.CustomerService;
import org.hopter.framework.annotation.Action;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.annotation.Inject;
import org.hopter.framework.bean.Data;
import org.hopter.framework.bean.FileParam;
import org.hopter.framework.bean.Param;
import org.hopter.framework.bean.View;
import org.hopter.framework.enums.RequestMethod;


import java.util.List;
import java.util.Map;

/**
 * 处理客户管理相关请求
 *
 * @author Angus
 * @date 2018/12/11
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入 客户列表 界面
     */
    @Action(method = RequestMethod.GET, path="/customer")
    public View index() {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示客户基本信息
     */
    @Action(method = RequestMethod.GET, path = "/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 进入 创建客户 界面
     */
    @Action(method = RequestMethod.GET, path = "/customer_create")
    public View create() {
        return new View("customer_create.jsp");
    }

    /**
     * 处理 创建客户 请求
     */
    @Action(method = RequestMethod.POST, path = "/customer_create")
    public Data createSubmit(Param param) {
        Map<String, Object> fieldMap = param.getFieldMap();
        FileParam fileParam = param.getFile("photo");
        boolean result = customerService.createCustomer(fieldMap, fileParam);
        return new Data(result);
    }

    /**
     * 进入 编辑客户 界面
     */
    @Action(method = RequestMethod.GET, path = "/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理 编辑客户 请求
     */
    @Action(method = RequestMethod.PUT, path = "/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理 删除客户 请求
     */
    @Action(method = RequestMethod.DELETE, path = "/customer_edit")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}