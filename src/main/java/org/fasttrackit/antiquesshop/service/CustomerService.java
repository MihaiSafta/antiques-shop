package org.fasttrackit.antiquesshop.service;

import org.fasttrackit.antiquesshop.domain.Customer;
import org.fasttrackit.antiquesshop.exception.ResourceNotFoundException;
import org.fasttrackit.antiquesshop.persistance.CustomerRepository;
import org.fasttrackit.antiquesshop.transfer.customer.CreateCustomerRequest;
import org.fasttrackit.antiquesshop.transfer.customer.UpdateCustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CreateCustomerRequest request) {
        LOGGER.info("Creating customer: {}", request);


        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());


        return customerRepository.save(customer);

    }

    public Customer getCustomer(long id) {
        LOGGER.info("Retrieving customer {}", id);
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer" + id + "not found."));

    }




    public Customer updateCustomer(long id, UpdateCustomerRequest request) {
        LOGGER.info("Updating {} {}", id, request);
        Customer customer = getCustomer(id);
        BeanUtils.copyProperties(request, customer);
        return customerRepository.save(customer);
    }



}
