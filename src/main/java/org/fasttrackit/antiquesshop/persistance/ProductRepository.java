package org.fasttrackit.antiquesshop.persistance;

import org.fasttrackit.antiquesshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
