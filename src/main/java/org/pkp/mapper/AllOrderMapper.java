package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pkp.dto.Response.AllOrderResponse;
import org.pkp.entity.Order;

import java.util.List;

@Mapper(componentModel = "spring",uses = {OrderMapper.class, CustomerMapper.class, EmployeesMapper.class})
public interface AllOrderMapper {

    // ✅ Map Order → AllOrderResponse
    @Mapping(source = "order", target = "orderBaseResponse")
    @Mapping(source = "customer", target = "customerResponse")
    @Mapping(source = "employee", target = "employeeResponse")
    @Mapping(source = "shipVia", target = "shipperResponse")
    //@Mapping(source = "product", target = "productResponse")
    AllOrderResponse toAllOrderResponse(Order order);

    // ✅ List Mapping
    List<AllOrderResponse> toAllOrderResponseList(List<Order> orders);
}