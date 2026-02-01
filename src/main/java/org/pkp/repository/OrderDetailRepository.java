package org.pkp.repository;

import org.pkp.entity.OrderDetails;
import org.pkp.entity.OrderDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, OrderDetailsId> {
}
