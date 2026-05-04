package org.pkp.services;

import org.pkp.dto.Request.OrderRequest;
import org.pkp.dto.Response.FullBaseOrderResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.dto.Response.OrderSaveResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LambdaStreamApiService {
    List<OrderResponse> findAllOrder(Integer employeeID);
    List<OrderResponse> findAllOrder(Integer employeeID, Integer ShipVia,String ShipCity);
    List<OrderResponse> findAllOrderSortByShipCountryAsc(Integer employeeID);
    List<OrderResponse> findAllOrderSortByShipCountryDesc(Integer employeeID);
    List<OrderResponse> findAllOrderLimit(Integer limit);
    List<OrderResponse> findAllOrderSkip(Integer skip);


}
