package org.hopter.demo.service;

import org.hopter.demo.model.Customer;
import org.hopter.framework.annotation.Service;
import org.hopter.framework.annotation.Transaction;
import org.hopter.framework.bean.FileParam;
import org.hopter.framework.helper.DatabaseHelper;
import org.hopter.framework.helper.UploadHelper;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 *
 * @author Angus
 * @date 2018/12/11
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        if (result) {
            UploadHelper.uploadFile("/tmp/upload/", fileParam);
        }
        return result;
    }

    /**
     * 更新客户
     */
    @Transaction
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    @Transaction
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
