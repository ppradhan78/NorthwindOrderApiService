package org.pkp.services.v2;

import org.pkp.dto.v2.request.OrderRequest;
import org.pkp.dto.v2.response.FullBaseOrderResponse;
import org.pkp.dto.v2.response.OrderResponse;
import org.pkp.dto.v2.response.OrderSaveResponse;
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
