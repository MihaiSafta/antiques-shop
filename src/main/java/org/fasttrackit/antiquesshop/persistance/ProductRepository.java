package org.fasttrackit.antiquesshop.persistance;

import org.fasttrackit.antiquesshop.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(String partialName, Pageable pageable);
    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(String partialName,int minimumQuantity, Pageable pageable);

}
