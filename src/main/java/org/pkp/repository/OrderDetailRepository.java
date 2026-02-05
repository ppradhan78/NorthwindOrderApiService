package org.pkp.repository;

import org.pkp.entity.OrderDetail;
import org.pkp.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    List<OrderDetail> findByIdOrderId(Integer orderId);
    Optional<OrderDetail> findByIdOrderIdAndIdProductId( Integer orderId,Integer productId );
}
