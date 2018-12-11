package org.hopter.demo.soap;

import org.hopter.demo.model.Customer;
import org.hopter.demo.service.CustomerService;
import org.hopter.framework.annotation.Inject;
import org.hopter.framework.annotation.Service;
import org.hopter.plugin.soap.Soap;

/**
 * 客户 SOAP 服务接口实现
 *
 * @author Angus
 * @date 2018/12/11
 */
@Soap
@Service
public class CustomerSoapServiceImpl implements CustomerSoapService {

    @Inject
    private CustomerService customerService;

    @Override
    public Customer getCustomer(long customerId) {
        return customerService.getCustomer(customerId);
    }
}
