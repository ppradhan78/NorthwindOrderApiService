package org.pkp.mapper.v2;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pkp.dto.v2.response.OrderResponse;
import org.pkp.entity.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "orderID", target = "orderId")
    @Mapping(source = "customer.customerID", target = "customerId")
    @Mapping(source = "employee.employeeID", target = "employeeId")
    @Mapping(source = "shipVia.shipperID", target = "shipVia")
    OrderResponse toResponse(Order order);
    List<OrderResponse> toResponseList(List<Order> order);
}
