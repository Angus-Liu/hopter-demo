package org.hopter.demo.soap;

import org.hopter.demo.model.Customer;
import org.hopter.plugin.soap.SoapHelper;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Angus
 * @date 2018/12/11
 */
public class CustomerSoapServiceTest {

    @Test
    public void getCustomer() {
        String wsdl = "http://localhost:8080/soap/CustomerSoapService";
        CustomerSoapService customerSoapService = SoapHelper.createClient(wsdl, CustomerSoapService.class);
        Customer customer = customerSoapService.getCustomer(1L);
        Assert.assertNotNull(customer);
    }
}