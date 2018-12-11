package org.hopter.demo.soap;

import org.hopter.demo.model.Customer;

/**
 * 客户 SOAP 接口
 *
 * @author Angus
 * @date 2018/12/11
 */
public interface CustomerSoapService {

    /**
     * 根据客户 ID 获取客户对象
     *
     * @param customerId 客户 ID
     * @return 客户对象
     */
    Customer getCustomer(long customerId);
}
