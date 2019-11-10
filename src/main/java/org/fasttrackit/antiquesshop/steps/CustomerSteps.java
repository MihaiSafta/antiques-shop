package org.fasttrackit.antiquesshop.steps;

import org.fasttrackit.antiquesshop.domain.Customer;
import org.fasttrackit.antiquesshop.service.CustomerService;
import org.fasttrackit.antiquesshop.transfer.customer.CreateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
@Component
public class CustomerSteps {
    @Autowired
    private CustomerService customerService;

    public Customer createCustomer(){
        CreateCustomerRequest request = new CreateCustomerRequest();
        request.setFirstName("Ionica");
        request.setLastName("Popica");
        Customer customer = customerService.createCustomer(request);
        assertThat(customer, notNullValue());
        assertThat(customer.getId(), notNullValue());
        assertThat(customer.getId(), greaterThan(0L));
        assertThat(customer.getFirstName(), is(request.getFirstName()));
        assertThat(customer.getLastName(), is(request.getLastName()));
        return customer;
    }
}
