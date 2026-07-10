package org.pkp.services.v2;

import org.pkp.dto.v2.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LambdaStreamApiService {
    List<OrderResponse> findAllOrder(Integer employeeID);
    List<OrderResponse> findAllOrder(Integer employeeID, Integer ShipVia,String ShipCity);
    List<OrderResponse> findAllOrderSortByShipCountryAsc(Integer employeeID);
    List<OrderResponse> findAllOrderSortByShipCountryDesc(Integer employeeID);
    List<OrderResponse> findAllOrderLimit(Integer limit);
    List<OrderResponse> findAllOrderSkip(Integer skip);


}
