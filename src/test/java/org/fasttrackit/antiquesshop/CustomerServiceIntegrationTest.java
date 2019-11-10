package org.fasttrackit.antiquesshop;


import org.fasttrackit.antiquesshop.service.CustomerService;
import org.fasttrackit.antiquesshop.steps.CustomerSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIntegrationTest {
@Autowired
private CustomerSteps customerSteps;
    @Test
    public void testCreateCustomer_whenValidRequest_thenReturnCreatedCustomer() {
        customerSteps.createCustomer();

    }
}
