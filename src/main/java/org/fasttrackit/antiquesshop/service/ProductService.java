package org.fasttrackit.antiquesshop.service;

import org.fasttrackit.antiquesshop.domain.Product;
import org.fasttrackit.antiquesshop.exception.ResourceNotFoundException;
import org.fasttrackit.antiquesshop.persistance.ProductRepository;
import org.fasttrackit.antiquesshop.transfer.product.CreateProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);


    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(CreateProductRequest request){
        LOGGER.info("Creating product: {}", request);


        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImagePath(request.getImagePath());

     return productRepository.save(product);

    }

    public Product getProduct(long id){
        LOGGER.info("Retrieving product {}", id);
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product" + id + "not found."));

    }

}
