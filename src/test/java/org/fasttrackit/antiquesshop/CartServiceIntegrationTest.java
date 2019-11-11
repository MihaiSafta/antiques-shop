package org.fasttrackit.antiquesshop;

import org.fasttrackit.antiquesshop.domain.Customer;
import org.fasttrackit.antiquesshop.service.CartService;
import org.fasttrackit.antiquesshop.steps.CustomerSteps;
import org.fasttrackit.antiquesshop.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.antiquesshop.transfer.product.CreateProductRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceIntegrationTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerSteps customerSteps;


    @Test
    public void testAddToCart_whenNewCart_thenCreateNewCart()   {
        Customer customer = customerSteps.createCustomer();

        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setCustomerId(customer.getId());
        request.setProductId(10L);
        cartService.addProductToCart(request);

    }


}
