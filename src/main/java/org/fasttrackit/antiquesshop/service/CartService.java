package org.fasttrackit.antiquesshop.service;

import org.fasttrackit.antiquesshop.domain.Cart;
import org.fasttrackit.antiquesshop.domain.Customer;
import org.fasttrackit.antiquesshop.persistance.CartRepository;
import org.fasttrackit.antiquesshop.transfer.cart.AddProductToCartRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
    private final CustomerService customerService;
    private final CartRepository cartRepository;
    @Autowired
    public CartService(CustomerService customerService, CartRepository cartRepository) {
        this.customerService = customerService;
        this.cartRepository = cartRepository;
    }
    @Transactional
    public void addProductToCart(AddProductToCartRequest request){
        LOGGER.info("Adding product to cart: {}", request);
        Cart cart = cartRepository.findById(request.getCustomerId()).orElse(new Cart());

        if (cart.getCustomer() == null){
            LOGGER.debug("Cart doesnt exist. Retrieving customer to create a new cart.");
            Customer customer = customerService.getCustomer(request.getCustomerId());
            cart.setCustomer(customer);
        }

        cartRepository.save(cart);

    }

}
