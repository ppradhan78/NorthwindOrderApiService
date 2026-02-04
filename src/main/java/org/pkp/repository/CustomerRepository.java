package org.pkp.repository;

import org.pkp.entity.Customer;
import org.pkp.entity.OrderDetail;
import org.pkp.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}