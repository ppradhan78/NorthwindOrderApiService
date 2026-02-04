package org.pkp.services;

import org.pkp.dto.Request.OrderRequest;
import org.pkp.dto.Response.AllOrderResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.dto.Response.OrderSaveResponse;
import org.pkp.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {
    List<AllOrderResponse> findAllOrder();
    List<OrderResponse> findAll();
    OrderSaveResponse save(OrderRequest request);
//    OrderResponse findById(Integer id);
    void deleteById(int id);

    List<Order> findByShipPostalCodeContaining(String shipPostalCode);
    List<Order> findByShipNameAndShipCity(String ShipName, String ShipCity)
            ;
    List<Order> findByShipName(String ShipName);
//    List<OrderEntity> findByCustomerID(String customerID);
}
