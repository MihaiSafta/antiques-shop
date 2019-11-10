package org.fasttrackit.antiquesshop.persistance;

import org.fasttrackit.antiquesshop.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {



}
