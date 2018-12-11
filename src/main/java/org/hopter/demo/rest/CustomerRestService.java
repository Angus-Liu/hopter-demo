package org.hopter.demo.rest;

import org.hopter.demo.model.Customer;
import org.hopter.demo.service.CustomerService;
import org.hopter.framework.annotation.Inject;
import org.hopter.framework.annotation.Service;
import org.hopter.plugin.rest.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 客户 REST 服务
 *
 * @author Angus
 * @date 2018/12/11
 */
@Rest
@Service
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRestService {

    @Inject
    private static CustomerService customerService;

    @GET
    @Path("/customer/{id}")
    public Customer getCustomer(@PathParam("id") long customerId) {
        return customerService.getCustomer(customerId);
    }
}
