package org.pkp.services;

import org.pkp.dto.Request.OrderRequest;
import org.pkp.dto.Response.FullBaseOrderResponse;
import org.pkp.dto.Response.FullOrderResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.dto.Response.OrderSaveResponse;
import org.pkp.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {
    List<FullBaseOrderResponse> findAllOrder();
    List<OrderResponse> findAll();
    OrderSaveResponse save(OrderRequest request);
    Optional<OrderResponse> findById(Integer id);
    void deleteById(int id);

    List<OrderResponse> findByShipPostalCodeContaining(String shipPostalCode);
    List<OrderResponse> findByShipNameAndShipCity(String ShipName, String ShipCity)
            ;
    List<OrderResponse> findByShipName(String ShipName);
    List<OrderResponse> findByCustomerID(String customerID);
}
