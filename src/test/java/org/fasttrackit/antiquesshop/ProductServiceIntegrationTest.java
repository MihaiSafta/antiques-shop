package org.fasttrackit.antiquesshop;
import org.junit.Test;
import org.fasttrackit.antiquesshop.domain.Product;
import org.fasttrackit.antiquesshop.exception.ResourceNotFoundException;
import org.fasttrackit.antiquesshop.service.ProductService;
import org.fasttrackit.antiquesshop.transfer.product.CreateProductRequest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTest {
    @Autowired
    private ProductService productService;
    @Test
    public void testCreateProduct_whenValidRequest_thenReturnCreatedProduct(){

        createProduct();
    }



    @Test(expected = TransactionSystemException.class)
    public  void testCreateProduct_whenInvalidRequest_thenThrowException(){

        CreateProductRequest request = new CreateProductRequest();

        productService.createProduct(request);
    }
    @Test
    public void testGetProductById_whenExistingEntity_thenReturnProduct(){
        Product createdProduct = createProduct();
        Product retrievedProduct = productService.getProduct(createdProduct.getId());
        assertThat(retrievedProduct, notNullValue());
        assertThat(retrievedProduct.getId(), is(createdProduct.getId()));
        assertThat(retrievedProduct.getName(), is(createdProduct.getName()));

    }
    @Test(expected = ResourceNotFoundException.class)
    public void testGetProduct_whenNonExistingEntity_thenTrowNotFoundException(){
        productService.getProduct(9999);
    }






    private Product createProduct() {
        CreateProductRequest request = new CreateProductRequest();
        request.setName("Omega");
        request.setDescription("Pocket Watch");
        request.setPrice(400);
        request.setQuantity(2);

        Product product = productService.createProduct(request);
        assertThat(product, notNullValue());
        assertThat(product.getId(), notNullValue());
        assertThat(product.getId(), greaterThan(0L));
        assertThat(product.getName(), is(request.getName()));
        assertThat(product.getDescription(), is(request.getDescription()));
        assertThat(product.getQuantity(), is(request.getQuantity()));
        assertThat(product.getPrice(), is(request.getPrice()));
        return product;
    }
}
