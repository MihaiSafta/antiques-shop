package org.fasttrackit.antiquesshop.persistance;

import org.fasttrackit.antiquesshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

        }
